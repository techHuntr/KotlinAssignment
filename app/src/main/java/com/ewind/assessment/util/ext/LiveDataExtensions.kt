package com.ewind.assessment.util.ext

import androidx.lifecycle.MutableLiveData
import com.ewind.assessment.util.Resource
import com.ewind.assessment.util.ResourceState

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T, message: String?) =
    postValue(Resource(ResourceState.SUCCESS, data, message))

fun <T> MutableLiveData<Resource<T>>.setLoading() =
    postValue(
        Resource(
            ResourceState.LOADING,
            value?.data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setError(message: String? = null) =
    postValue(
        Resource(
            ResourceState.ERROR,
            value?.data,
            message
        )
    )