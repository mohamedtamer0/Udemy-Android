package com.example.myservices

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast

class MyService:Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

//    override fun onCreate() {
//        super.onCreate()
//    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showMessage()
        return super.onStartCommand(intent, flags, startId)
    }

    fun showMessage() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                Toast.makeText(applicationContext, "Hello World", Toast.LENGTH_SHORT).show()
            },
            5000
        )
    }

//    override fun onDestroy() {
//        super.onDestroy()
//    }
}