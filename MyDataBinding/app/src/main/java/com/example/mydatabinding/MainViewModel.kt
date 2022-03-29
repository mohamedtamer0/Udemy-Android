package com.example.mydatabinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val color = MutableLiveData<MyColors>()
    fun changeColorRandomly() {
        color.postValue(MyColors.values().random())
    }
}