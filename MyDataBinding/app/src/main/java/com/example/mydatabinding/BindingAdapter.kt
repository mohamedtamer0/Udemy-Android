package com.example.mydatabinding


import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["myColors"])
fun setMyColors(view: View, myColors: MyColors?) {
    when (myColors) {
        MyColors.RED -> view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.red))
        MyColors.YELLOW -> view.setBackgroundColor(
            ContextCompat.getColor(
                view.context,
                R.color.yellow
            )
        )
        MyColors.BLUE -> view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.blue))
    }
}

@BindingAdapter(value = ["showIfTrue"])
fun setCustomVisibility(view: View, value: Boolean?) {
    if (value == true) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}