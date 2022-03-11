package com.example.mysqliteapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mysqliteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var databaseHelper: ArticleDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databaseHelper = ArticleDbHelper(applicationContext)

        addListeners()
    }

    private fun addListeners() {
        binding.btnSave.setOnClickListener {
            val title = binding.inputTitle.text.toString()
            val body = binding.inputBody.text.toString()
            val newEntry = ContentValues().apply {
                put(DB.TITLE, title)
                put(DB.BODY, body)
            }
            databaseHelper.writableDatabase.insert(DB.TABLE_NAME, null, newEntry)
        }
    }
}