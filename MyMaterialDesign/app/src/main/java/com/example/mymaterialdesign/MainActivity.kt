package com.example.mymaterialdesign

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mymaterialdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            Toast.makeText(this, "You Clicked Me", Toast.LENGTH_LONG).show()
        }

        binding.btnDialog.setOnClickListener {
            showMeDialog()
        }

    }


    private fun showMeDialog() {
        val builder = AlertDialog.Builder(this)
        builder.apply {
            setTitle("title")
            setMessage("message")
            setPositiveButton("yes", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this@MainActivity, "Positive button Clicked", Toast.LENGTH_LONG)
                    .show()
            })
            setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this@MainActivity, "Negative button Clicked", Toast.LENGTH_LONG)
                    .show()
            })
        }
        val dialog = builder.create()
        dialog.show()
    }


}