package com.ewind.assessment.domain.repository

import com.ewind.assessment.data.remote.model.WorkModel
import io.reactivex.Observable

interface WorkRepository {
    fun getWorks(dates: String): Observable<List<WorkModel>>
}