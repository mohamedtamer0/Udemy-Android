package com.example.myretrofitapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myretrofitapp.databinding.ItemMovieBinding
import com.example.myretrofitapp.model.Movie

class MovieAdapter(private var items: List<Movie>, private val listener: MovieInteractionListener) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.item = currentItem
        holder.binding.listener = listener

    }

    fun setItems(newItems: List<Movie>) {
        items = newItems
    }

    override fun getItemCount() = items.size

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMovieBinding.bind(itemView)
    }
}

interface MovieInteractionListener {
    fun onClickMovie(movie: Movie)
}