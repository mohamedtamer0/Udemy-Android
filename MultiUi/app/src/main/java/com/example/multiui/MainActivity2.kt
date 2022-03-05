package com.example.multiui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multiui.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(MainActivity.Constant.extraName)
        binding.textData.text = name

    }
}