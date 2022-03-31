package com.example.myretrofitapp.model

import com.google.gson.annotations.SerializedName

data class RateBody(
    @SerializedName("value")
    val stars: Int
)
