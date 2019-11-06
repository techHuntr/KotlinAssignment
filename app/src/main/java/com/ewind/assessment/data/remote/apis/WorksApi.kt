package com.ewind.assessment.data.remote.apis


import com.ewind.assessment.data.remote.model.Response
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface WorksApi {
    @GET("contractor/shifts")
    fun getJobs(@Query("dates") date: String): Observable<Response>
}