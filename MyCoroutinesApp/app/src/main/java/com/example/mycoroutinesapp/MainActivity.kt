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
    //val customScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jobParent = lifecycleScope.launch {
            val job1 = launch { repeatLogs1() }
            val job2 = launch { repeatLogs2() }
        }

        binding.btnCancel.setOnClickListener {
            jobParent.cancel()
        }


        //Log.d(TAG, "after Coroutine")

//        runBlocking {
//            fakeApiRequest()
//        }
    }


    suspend fun repeatLogs1() {
        delay(5000)
        Log.d(TAG, "response 1")


//        delay(2500)
//        withContext(Dispatchers.Main) {
//            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
//            finish()
//        }

    }

    suspend fun repeatLogs2() {
        delay(3000)
        Log.d(TAG, "response 2")
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

//
//    override fun onDestroy() {
//        super.onDestroy()
//        customScope.cancel()
//    }
}