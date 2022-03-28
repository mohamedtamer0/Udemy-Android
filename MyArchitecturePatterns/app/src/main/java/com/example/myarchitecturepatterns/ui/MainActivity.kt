package com.example.myarchitecturepatterns.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myarchitecturepatterns.databinding.ActivityMainBinding
import com.example.myarchitecturepatterns.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()

    }

    private fun setup() {
        viewModel.getUserInfo()
        binding.buttonFetchWisdom.setOnClickListener {
            viewModel.getAWisdom()
        }

        viewModel.currentUser.observe(this) {
            binding.textUserName.text = it.username
        }

        viewModel.wisdom.observe(this) {
            binding.apply {
                textDate.text = it.publishDate
                textContent.text = it.content
            }
        }

    }


}