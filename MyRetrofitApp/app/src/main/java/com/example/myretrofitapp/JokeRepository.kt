package com.example.myretrofitapp

class JokeRepository {
    suspend fun getRandomJoke() = API.apiService.getRandomJoke()
}