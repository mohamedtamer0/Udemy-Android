package com.example.myrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myrxjava.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foo()
    }


    private fun foo() {

    }
}