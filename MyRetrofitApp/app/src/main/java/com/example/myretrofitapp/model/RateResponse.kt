package com.example.myretrofitapp.model


import com.google.gson.annotations.SerializedName

data class RateResponse(
    @SerializedName("value")
    val value: Double? = null
)