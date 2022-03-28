package com.example.myarchitecturepatterns.repository

import com.example.myarchitecturepatterns.FakeApiService
import com.example.myarchitecturepatterns.FakeDatabase

class MainRepository {

    private val api = FakeApiService()
    private val database = FakeDatabase()

    fun getCurrentUser() = database.getCurrentUser()
    fun getRandomWisdom() = api.getRandomWisdom()
}