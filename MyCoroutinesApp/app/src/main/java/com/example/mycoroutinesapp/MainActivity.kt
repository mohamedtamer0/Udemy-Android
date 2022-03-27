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


//        val jobParent = lifecycleScope.launch {
//            val deferred1 = async { repeatLogs1() }
//            val deferred2 = async { repeatLogs2() }
//
//            Log.d(TAG, deferred1.await())
//            Log.d(TAG, deferred2.await())
//        }


        //Log.d(TAG, "after Coroutine")

//        runBlocking {
//            fakeApiRequest()
//        }

        playWithCoroutine()
        binding.btnCancel.setOnClickListener {
            job4.cancel()
        }
    }

    lateinit var job1: Job
    lateinit var job2: Job
    lateinit var job3: Job
    lateinit var job4: Job
    lateinit var job5: Job


    private fun playWithCoroutine() {
        job1 = lifecycleScope.launch {
            delay(2000)
            job2 = launch {
                delay(2000)
                Log.d(TAG, "I am job2")
                job4 = launch {
                    delay(2000)
                    Log.d(TAG, "I am job4")
                }
                job5 = launch {
                    delay(2000)
                    Log.d(TAG, "I am job5")
                }
            }
            job3 = launch {
                delay(2000)
                Log.d(TAG, "I am job3")
            }
            Log.d(TAG, "I am job1")
        }
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