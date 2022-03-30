package com.example.myretrofitapp

import com.example.myretrofitapp.networking.JokeApiService
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory





object API {
    private val BASE_URL = "https://v2.jokeapi.dev/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(JokeApiService::class.java)
}