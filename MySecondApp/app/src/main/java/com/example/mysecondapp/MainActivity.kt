package com.example.mysecondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textTitle: TextView
    lateinit var buttonClick: Button
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textTitle = findViewById(R.id.text_title)
        textTitle.text = "This is First App"

        buttonClick = findViewById(R.id.btn_click)
        buttonClick.text = "Don't Click Here"

        buttonClick.setOnClickListener {
            counter++
            textTitle.text = "Counter $counter"
        }


    }
}