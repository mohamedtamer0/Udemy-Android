package com.example.mysolid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mysolid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var database: MtDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = MtDatabase()
        addListeners()
    }

    private fun addListeners() {
        binding.buttonCount.setOnClickListener {
            val studentsCount = database.getAllStudentsCount()
            binding.textView.text = studentsCount.toString()
        }
    }

}