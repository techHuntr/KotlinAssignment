package com.ewind.assessment.data.remote.model


import com.google.gson.annotations.SerializedName

data class Photo(
  @SerializedName("formats")
  var formats: List<Format>
)