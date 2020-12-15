package com.hackaprende.tinynetflix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hackaprende.tinynetflix.databinding.MovieListItemBinding

class MovieAdapter(val onItemClickListener: (Movie) -> Unit) : ListAdapter<Movie, MovieAdapter.ViewHolder>(
        DiffCallback
    ) {

    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    inner class ViewHolder(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
            binding.root.setOnClickListener {
                onItemClickListener(movie)
            }
        }
    }
}