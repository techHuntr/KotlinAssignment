package com.ewind.assessment

import com.ewind.assessment.data.remote.apis.WorksApi
import com.ewind.assessment.util.network.createNetworkClient
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit

val networkModule: Module = module {
    single { worksApi }
}

val retrofit: Retrofit =
    createNetworkClient(BuildConfig.API_URL, BuildConfig.DEBUG)

val worksApi: WorksApi = retrofit.create(WorksApi::class.java)
