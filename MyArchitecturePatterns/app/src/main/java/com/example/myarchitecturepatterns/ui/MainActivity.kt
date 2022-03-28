package com.example.myarchitecturepatterns.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myarchitecturepatterns.FakeApiService
import com.example.myarchitecturepatterns.FakeDatabase
import com.example.myarchitecturepatterns.databinding.ActivityMainBinding
import com.example.myarchitecturepatterns.model.User
import com.example.myarchitecturepatterns.model.Wisdom
import com.example.myarchitecturepatterns.presenter.MainPresenter

class MainActivity : AppCompatActivity(), IMainView {

    lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()

    }

    private fun setup() {
        presenter.view = this
        presenter.getUserInfo()
        binding.buttonFetchWisdom.setOnClickListener {
            presenter.getAWisdom()
        }
    }

    override fun onUserInfoSuccess(user: User) {
        binding.textUserName.text = user.username
    }

    override fun onWisdomSuccess(wisdom: Wisdom) {
        binding.apply {
            textDate.text = wisdom.publishDate
            textContent.text = wisdom.content
        }
    }


}