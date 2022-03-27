package com.example.mycoroutinesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.mycoroutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val customScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customScope.launch(Dispatchers.IO) {
            repeatLogs()
        }


        //Log.d(TAG, "after Coroutine")

//        runBlocking {
//            fakeApiRequest()
//        }
    }


    suspend fun repeatLogs() {
        delay(2500)
        withContext(Dispatchers.Main) {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            finish()
        }
        while (true) {
            Log.d(TAG, "Hi , it's working")
            delay(1000)
        }
    }


//    suspend fun fakeApiRequest() {
//        delay(2500)
//        Log.d(TAG, "fakeApiRequest")
//        Log.d(TAG, Thread.currentThread().name)
//        withContext(Dispatchers.Main) {
//            binding.txtView.text = "fake request"
//            Log.d(TAG, Thread.currentThread().name)
//        }
//    }

    companion object {
        private const val TAG = "Tamer"
    }


    override fun onDestroy() {
        super.onDestroy()
        customScope.cancel()
    }
}