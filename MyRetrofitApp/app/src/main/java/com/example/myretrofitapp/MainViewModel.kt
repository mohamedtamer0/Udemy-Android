package com.example.myretrofitapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofitapp.model.JokeResponse
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    val joke = MutableLiveData<JokeResponse>()

    val repository = JokeRepository()

    init {
        getRandomJoke()
    }

    private fun getRandomJoke() {
        viewModelScope.launch {
            joke.postValue(repository.getRandomJoke())
        }
    }

}