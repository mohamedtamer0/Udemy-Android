package com.example.myrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doOnTextChanged
import com.example.myrxjava.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var mDisposable: Disposable
    lateinit var compositeDisposable: CompositeDisposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foo()
    }

    private fun foo() {
        val completable = Completable.create { emitter ->
            binding.editTxt.doOnTextChanged { text, start, before, count ->
                if (text.toString() == "000") {
                    emitter.onComplete()
                }
            }

        }

        completable.subscribe(object : CompletableObserver {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onComplete() {
                Log.d(TAG, "onComplete")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError")
            }

        })


        val single = Single.just(5)
        single.subscribe(object : SingleObserver<Int> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onSuccess(t: Int) {
                Log.d(TAG, "onSuccess: $t")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: ${e?.message}")
            }

        })


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

        //val observable = Observable.range(1, 1000)

//        compositeDisposable.add(
//            observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe { t ->
//                    Log.d(TAG, "onNext: $t - ${Thread.currentThread().name}")
//                }
//        )


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

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
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