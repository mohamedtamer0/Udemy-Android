package com.example.myarchitecturepatterns

import com.example.myarchitecturepatterns.model.Wisdom

class FakeApiService {
    private val wisdomList = listOf<Wisdom>(
        Wisdom(
            "Don’t let the noise of others’ opinions drown out your own inner voice.",
            "2022/3/28"
        ),
        Wisdom(
            "Be a yardstick of quality. Some people aren’t used to an environment where excellence is expected.",
            "2022/3/28"
        ),
        Wisdom("Stay hungry. Stay foolish.", "2022/3/28"),
        Wisdom(
            "We’re here to put a dent in the universe. Otherwise why else even be here?",
            "2022/3/28"
        ),
        Wisdom("Innovation distinguishes between a leader and a follower.", "2022/3/28"),
        Wisdom("Your time is limited, so don’t waste it living someone else’s life.", "2022/3/28")
    )

    fun getRandomWisdom(): Wisdom {
        val random = (Math.random() * wisdomList.size).toInt()
        return wisdomList[random]
    }
}