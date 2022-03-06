package com.example.multiui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.multiui.MainActivity.Constant.extraName
import com.example.multiui.databinding.ActivityMain2Binding
import com.example.multiui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(LOG_TAG, "onCreate")
        addCallbacks()
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    companion object {
        const val LOG_TAG = "FIRST_ACTIVITY"
    }


    private fun addCallbacks() {
        binding.button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://google.com")
            startActivity(intent)
        }


        binding.btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            val phoneNumber = binding.textPhone.text.toString()
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }
    }

    object Constant {
        val extraName = "extraName"
    }

}