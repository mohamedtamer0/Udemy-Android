package com.example.myinternalexternalstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.example.myinternalexternalstorage.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addListeners()
    }


    private fun addListeners() {
        binding.save.setOnClickListener {
            val text = binding.edittext.text.toString()
            saveTextToFile(text)
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveTextToFile(text: String) {
        val path = Environment.getExternalStorageDirectory().path
        val fileName = "sample.txt"
        val file = File("$path/$fileName")
        file.writeText(text)
    }


}