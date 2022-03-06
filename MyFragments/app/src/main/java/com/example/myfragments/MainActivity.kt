package com.example.myfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    val myFirstFragment = OneFragment()
    val mySecondFragment = TwoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initSubView()
        initButton()
    }

    private fun initButton() {
        findViewById<Button>(R.id.button_change).setOnClickListener {
            showSecondFragment()
        }

        findViewById<Button>(R.id.button_remove).setOnClickListener {
            removeFragment(mySecondFragment)
        }

    }


    private fun removeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.remove(fragment)
        transaction.commit()
    }

    private fun showSecondFragment() {
        replaceFragment(mySecondFragment)
    }

    private fun initSubView() {
        addFragment(myFirstFragment)
    }


    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment)
        transaction.commit()
    }


    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }


}