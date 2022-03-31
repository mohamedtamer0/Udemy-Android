package com.example.myretrofitapp

import com.example.myretrofitapp.networking.MovieService
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory





object API {
    private val BASE_URL = "https://api.themoviedb.org/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(MovieService::class.java)
}