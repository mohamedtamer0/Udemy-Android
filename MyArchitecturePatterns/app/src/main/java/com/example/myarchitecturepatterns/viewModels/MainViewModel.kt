package com.example.myarchitecturepatterns.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myarchitecturepatterns.model.User
import com.example.myarchitecturepatterns.model.Wisdom
import com.example.myarchitecturepatterns.repository.MainRepository

class MainViewModel:ViewModel() {
    private val repository = MainRepository()
    val currentUser = MutableLiveData<User>()
    val wisdom = MutableLiveData<Wisdom>()


    fun getUserInfo() {
        currentUser.postValue(repository.getCurrentUser())
    }

    fun getAWisdom() {
        wisdom.postValue(repository.getRandomWisdom())
    }
}