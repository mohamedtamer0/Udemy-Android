package com.example.myfragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myfragments.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LOG_TAG, "onCreateView")
        binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LOG_TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //deprecated don't use it
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LOG_TAG, "onDetach")
    }


    companion object {
        const val LOG_TAG = "FFF_One"
    }
}