package com.example.myrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myrxjava.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foo()
    }

    private fun foo() {
        val list = listOf(1,2,3,4,5,6,7,8,9,10,11,12)
        val observable = Observable.fromIterable(list)

        observable.subscribe { t ->
            Log.d(TAG, "onNext: $t")
        }


//        val observer = object : Observer<Int> {
//            override fun onSubscribe(d: Disposable) {
//                Log.d(TAG, "onSubscribe: ")
//            }
//
//            override fun onNext(t: Int) {
//                Log.d(TAG, "onNext: $t")
//            }
//
//            override fun onError(e: Throwable) {
//                Log.d(TAG, "onError: ")
//            }
//
//            override fun onComplete() {
//                Log.d(TAG, "onComplete: ")
//            }
//
//        }
//
//        happy.subscribe(observer)


    }


//    private fun foo() {
//        var foo = 5
//        Log.d(TAG, foo.toString())
//        foo = 10
//        Log.d(TAG, foo.toString())
//        foo = 66
//        Log.d(TAG, foo.toString())
//        foo = 90
//        Log.d(TAG, foo.toString())
//        foo = 550
//        Log.d(TAG, foo.toString())
//        foo = 800
//        Log.d(TAG, foo.toString())
//    }

    companion object {
        const val TAG = "Tamer"
    }
}