package com.example.myretrofitapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofitapp.model.State
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val repository = JokeRepository()



}