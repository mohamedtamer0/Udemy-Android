package com.example.myretrofitapp

import com.example.myretrofitapp.model.JokeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokeRepository {
    suspend fun getRandomJoke():Flow<JokeResponse?> {
        return flow {
            emit(API.apiService.getRandomJoke().body())
        }
    }
}