package com.ewind.assessment.ui

import com.ewind.assessment.data.repository.WorkRepositoryImpl
import com.ewind.assessment.domain.repository.WorkRepository
import com.ewind.assessment.domain.usecase.WorkUseCase
import com.ewind.assessment.ui.main.home.MainViewModel
import com.ewind.assessment.ui.main.work.WorkViewModule
import com.ewind.assessment.util.googlemap.GoogleMapManager
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.loadKoinModules

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        viewModelModule,
        useCaseModule,
        repositoryModule,
        googleMapModule
    )
}

val viewModelModule: Module = module {
    viewModel { MainViewModel(workUseCase = get()) }
    viewModel { WorkViewModule(googleMapManager = get()) }
}

val useCaseModule: Module = module {
    factory { WorkUseCase(workRepository = get()) }
}

val repositoryModule: Module = module {
    single<WorkRepository> {
        WorkRepositoryImpl(
            worksApi = get()
        )
    }
}

val googleMapModule: Module = module {
    single {
        GoogleMapManager()
    }
}