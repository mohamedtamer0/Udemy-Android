package com.example.myretrofitapp

import com.example.myretrofitapp.model.JokeResponse
import com.example.myretrofitapp.model.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokeRepository {
    suspend fun getRandomJoke(): Flow<State<JokeResponse?>> {
        return flow {
            emit(State.Loading)
            val result = API.apiService.getRandomJoke()
            if (result.isSuccessful) {
                emit(State.Success(result.body()))
            } else {
                emit(State.Error(result.message()))
            }
        }
    }
}