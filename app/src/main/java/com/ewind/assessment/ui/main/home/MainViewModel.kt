package com.ewind.assessment.ui.main.home

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.ewind.assessment.data.remote.model.WorkModel
import com.ewind.assessment.domain.usecase.WorkUseCase
import com.ewind.assessment.ui.main.base.BaseViewModel
import com.ewind.assessment.util.Resource
import com.ewind.assessment.util.TempVar
import com.ewind.assessment.util.ext.setError
import com.ewind.assessment.util.ext.setSuccess
import com.ewind.assessment.util.network.ErrorHandler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(val workUseCase: WorkUseCase) : BaseViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val workliveDate = MutableLiveData<Resource<MutableList<WorkModel>>>()
    val isRefreshing = ObservableBoolean(false)
    var isLoading = false

    fun getWorks(dates: String) {
        compositeDisposable.add(
            workUseCase.getWorks(dates)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    isRefreshing.set(true)
                    isLoading = true
                }
                .doOnTerminate {
                    isRefreshing.set(false)
                    isLoading = false
                }
                .subscribe(
                    { listWork ->
                        if (listWork.isNotEmpty()) {
                            TempVar.per_page = listWork.size
                            listWork[0].visibleDate = true
                        }
                        workliveDate.setSuccess(listWork.toMutableList(), null)
                    },
                    {
                        workliveDate.setError(ErrorHandler.getApiErrorMessage(it))
                    })
        )
    }

    override fun start() {

    }

    override fun stop() {

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}