package com.example.myarchitecturepatterns.presenter

import com.example.myarchitecturepatterns.FakeApiService
import com.example.myarchitecturepatterns.FakeDatabase
import com.example.myarchitecturepatterns.repository.MainRepository
import com.example.myarchitecturepatterns.ui.IMainView

class MainPresenter {


    lateinit var view: IMainView
    private val repository = MainRepository()

    fun getUserInfo() {
        val result = repository.getCurrentUser()
        view.onUserInfoSuccess(result)
    }

    fun getAWisdom() {
        val result = repository.getRandomWisdom()
        view.onWisdomSuccess(result)
    }
}