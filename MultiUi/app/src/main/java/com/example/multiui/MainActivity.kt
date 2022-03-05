package com.example.multiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multiui.MainActivity.Constant.extraName
import com.example.multiui.databinding.ActivityMain2Binding
import com.example.multiui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addCallbacks()
    }

    private fun addCallbacks() {
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            val name = binding.textName.text.toString()
            intent.putExtra(extraName, name)
            startActivity(intent)
        }
    }

    object Constant {
        val extraName = "extraName"
    }

}