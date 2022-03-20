package com.example.myapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import com.example.myapitest.databinding.ActivityMainBinding
import okhttp3.*
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFetch.setOnClickListener {
            //makeRequest()

            makeRequestUsingOKHTTP()
        }
    }

    private fun makeRequestUsingOKHTTP() {
        val request = Request.Builder().url("https://v2.jokeapi.dev/joke/Any").build()
        client.newCall(request).enqueue(object:Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d(LOG_TAG, "onFailure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread {
                    binding.textResult.text = response.body?.string()
                }
            }

        })
    }

    private fun makeRequest() {
//        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
//        StrictMode.setThreadPolicy(policy)

        val url = URL("https://v2.jokeapi.dev/joke/Any")
        val connection = url.openConnection()
        val inputStream = connection.getInputStream()
        val inputStreamReader = InputStreamReader(inputStream)
        val result = inputStreamReader.readText()
        binding.textResult.text = result
    }


    companion object {
        private const val LOG_TAG = "MAINACTIVITY"
    }
}