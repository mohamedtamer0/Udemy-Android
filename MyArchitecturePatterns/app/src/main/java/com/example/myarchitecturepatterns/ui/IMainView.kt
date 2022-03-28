package com.example.myarchitecturepatterns.ui

import com.example.myarchitecturepatterns.model.User
import com.example.myarchitecturepatterns.model.Wisdom

interface IMainView {
    fun onUserInfoSuccess(user: User)
    fun onWisdomSuccess(wisdom: Wisdom)
}