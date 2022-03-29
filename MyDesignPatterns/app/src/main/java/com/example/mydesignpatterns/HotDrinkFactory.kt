package com.example.mydesignpatterns

class HotDrinkFactory {
    fun create(name: String): HotDrink {
        return when (name) {
            "Cappucchino" -> Cappucchino()
            "Latte" -> Latte()
            "Mocha" -> Mocha()
            else -> throw  Exception("None Hot Drink Type")
        }
    }
}