package com.example.myarchitecturepatterns

import com.example.myarchitecturepatterns.model.User

class FakeDatabase {
    fun getCurrentUser(): User {
        return User("Mohamed Tamer", 1996)
    }
}