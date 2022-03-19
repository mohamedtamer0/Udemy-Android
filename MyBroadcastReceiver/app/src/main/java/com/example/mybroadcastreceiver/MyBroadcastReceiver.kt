package com.example.mybroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        when(p1?.action) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                if (p1.extras?.getBoolean("state") == true) {
                    Toast.makeText(p0, "تمني لك رحلة سعيدة", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(p0, "حمدلله علي السلامة", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}