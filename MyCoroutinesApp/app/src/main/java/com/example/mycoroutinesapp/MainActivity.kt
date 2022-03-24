package com.example.mycoroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mycoroutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.IO) {
            fakeApiRequest()
        }


        //Log.d(TAG, "after Coroutine")

//        runBlocking {
//            fakeApiRequest()
//        }
    }

    suspend fun fakeApiRequest() {
        delay(2500)
        Log.d(TAG, "fakeApiRequest")
        Log.d(TAG, Thread.currentThread().name)
        withContext(Dispatchers.Main) {
            binding.txtView.text = "fake request"
            Log.d(TAG, Thread.currentThread().name)
        }
    }

    companion object {
        private const val TAG = "Tamer"
    }
}