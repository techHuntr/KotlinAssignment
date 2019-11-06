package com.ewind.assessment.data.remote.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("data")
    var data: Any? = null
)