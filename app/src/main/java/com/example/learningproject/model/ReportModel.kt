package com.example.learningproject.model

import com.google.gson.annotations.SerializedName

data class ReportModel(
    @SerializedName("to") val token: String,
    @SerializedName("ok") val state: Boolean
)
