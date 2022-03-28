package com.example.myarchitecturepatterns.presenter

import com.example.myarchitecturepatterns.FakeApiService
import com.example.myarchitecturepatterns.FakeDatabase
import com.example.myarchitecturepatterns.ui.IMainView

class MainPresenter {

    private val api = FakeApiService()
    private val database = FakeDatabase()
    lateinit var view: IMainView

    fun getUserInfo() {
        val result = database.getCurrentUser()
        view.onUserInfoSuccess(result)
    }

    fun getAWisdom() {
        val result = api.getRandomWisdom()
        view.onWisdomSuccess(result)
    }
}