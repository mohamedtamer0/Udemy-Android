package com.example.mysecondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {

    lateinit var buttonClick: Button
    lateinit var switchMat: SwitchMaterial
    lateinit var textUserName: EditText
    lateinit var textTitle: TextView
    lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        addCallbacks()

    }

    private fun addCallbacks() {
//        switchMat.setOnCheckedChangeListener { compoundButton, b ->
//            buttonClick.isEnabled = b
//        }
//        textUserName.addTextChangedListener { text ->
//            Log.v(LOG_TAG, text.toString())
//        }

        buttonClick.setOnClickListener {
//            showMessage()
//            updateTitle()
//            updateColor()
            updateLogo()
        }

    }


    private fun updateLogo() {
        val mIcon = ContextCompat.getDrawable(this, R.drawable.ic_android_black_24dp)
        img.setImageDrawable(mIcon)
    }


    private fun updateColor() {
        val purple = ContextCompat.getColor(this, R.color.purple_200)
        textTitle.setBackgroundColor(purple)
    }


    private fun updateTitle() {
        textTitle.text = getString(R.string.my_name)
    }


//    private fun showMessage() {
//        val msg = textUserName.text.toString()
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
//    }


    private fun initView() {
        buttonClick = findViewById(R.id.btn_click)
        switchMat = findViewById(R.id.switch_username)
        textUserName = findViewById(R.id.text_username)
        textTitle = findViewById(R.id.txtTitle)
        img = findViewById(R.id.logo)
    }

    companion object {
        const val LOG_TAG = "MyActivity"
    }

}