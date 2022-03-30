package com.example.myretrofitapp.model


import com.google.gson.annotations.SerializedName

data class Flags(
    @SerializedName("explicit")
    val explicit: Boolean? = null,
    @SerializedName("nsfw")
    val nsfw: Boolean? = null,
    @SerializedName("political")
    val political: Boolean? = null,
    @SerializedName("racist")
    val racist: Boolean? = null,
    @SerializedName("religious")
    val religious: Boolean? = null,
    @SerializedName("sexist")
    val sexist: Boolean? = null
)