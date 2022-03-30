package com.example.myretrofitapp

import com.example.myretrofitapp.model.JokeResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface JokeApiService {
    @GET("joke/Any")
    fun getRandomJoke(): Single<JokeResponse>
}

object API {
    private val BASE_URL = "https://v2.jokeapi.dev/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    val apiService = retrofit.create(JokeApiService::class.java)
}