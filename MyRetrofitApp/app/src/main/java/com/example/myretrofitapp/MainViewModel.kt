package com.example.myretrofitapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myretrofitapp.model.JokeResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class MainViewModel : ViewModel() {
    val joke = MutableLiveData<JokeResponse>()

    init {
        getRandomJoke()
    }

    private fun getRandomJoke() {
        API.apiService.getRandomJoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    joke.postValue(it)
                },
                {

                }
            )
    }

}