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
        var firstResponse: String? = null
        var secondResponse: String? = null

        val jobParent = lifecycleScope.launch {
            val job1 = launch { firstResponse = repeatLogs1() }
            val job2 = launch { secondResponse = repeatLogs2() }

            job1.join()
            job2.join()
            Log.d(TAG, firstResponse.toString())
            Log.d(TAG, secondResponse.toString())
        }




        //Log.d(TAG, "after Coroutine")

//        runBlocking {
//            fakeApiRequest()
//        }
    }


    suspend fun repeatLogs1(): String {
        delay(5000)
        return "response 1"


//        delay(2500)
//        withContext(Dispatchers.Main) {
//            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
//            finish()
//        }

    }

    suspend fun repeatLogs2(): String {
        delay(3000)
        return "response 2"
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