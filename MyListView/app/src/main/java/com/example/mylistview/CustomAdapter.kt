package com.example.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class CustomAdapter(context: Context, dogs: ArrayList<Dogs>) :
    ArrayAdapter<Dogs>(context, R.layout.row, dogs) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val listViewItem = LayoutInflater.from(context).inflate(R.layout.row, parent, false)
        val dogs = getItem(position)

        val textView1: TextView = listViewItem.findViewById(R.id.textView1)
        val textView2: TextView = listViewItem.findViewById(R.id.textView2)
        val imageView: ImageView = listViewItem.findViewById(R.id.imageView)

        textView1.text = dogs!!.name
        textView2.text = dogs.desc
        imageView.setImageResource(dogs.image)

        return listViewItem
    }


}

