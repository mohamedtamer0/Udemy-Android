package com.example.myarchitecturepatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myarchitecturepatterns.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val api = FakeApiService()
    val database = FakeDatabase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchUserInfo()

    }

    fun fetchAWisdom(view: View) {
        val result = api.getRandomWisdom()
        binding.apply {
            textDate.text = result.publishDate
            textContent.text = result.content
        }
    }

    fun fetchUserInfo() {
        val result = database.getCurrentUser()
        binding.textUserName.text = result.username
    }

}