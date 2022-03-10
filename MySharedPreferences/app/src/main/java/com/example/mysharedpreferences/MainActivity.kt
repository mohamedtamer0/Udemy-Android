package com.example.mysharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = binding.user
        val pass = binding.pass

        binding.login.setOnClickListener {
            val shardPreferences: SharedPreferences =
                getSharedPreferences("myData", Context.MODE_PRIVATE)
            val editor = shardPreferences.edit()
            editor.putString("u", user.text.toString())
            editor.putString("p", pass.text.toString())
            editor.apply()

            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
        }

        binding.load.setOnClickListener {
            val shardPreferences: SharedPreferences =
                getSharedPreferences("myData", Context.MODE_PRIVATE)
            val userName = shardPreferences.getString("u", "None")
            val password = shardPreferences.getString("p", "")
            user.setText(userName)
            pass.setText(password)
        }
    }
}