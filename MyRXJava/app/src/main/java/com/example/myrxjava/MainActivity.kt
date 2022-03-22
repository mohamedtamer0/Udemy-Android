package com.example.myrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myrxjava.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foo()
    }

    private fun foo() {
        //val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 6, 7, 2, 5, 8, 10, 11, 12)
        //val observable = Observable.fromIterable(list).repeat(3)
        //val observable = Observable.range(10,20).repeat(2)
        //val observable = Observable.interval(1,TimeUnit.SECONDS).take(5,TimeUnit.SECONDS)
        //val observable = Observable.range(1,100).takeLast(20)
        //val observable = Observable.timer(10,TimeUnit.SECONDS)
        //val observable = Observable.fromIterable(list).distinct()
        //val observable = Observable.fromIterable(list).buffer(3)
        //val observable = Observable.range(2, 20).map { it * 2 }

        //val someObservable = Observable.interval(500, TimeUnit.MILLISECONDS).take(10).map { it * 10 }
        //val observable = Observable.interval(1, TimeUnit.SECONDS).take(10).map { it * 2 }.mergeWith(someObservable)

        val observable = Observable.range(1,1000)

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