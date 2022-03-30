package com.example.myretrofitapp.networking

import com.example.myretrofitapp.model.JokeResponse
import retrofit2.http.GET

interface JokeApiService {
    @GET("joke/Any")
    suspend fun getRandomJoke(): JokeResponse
}