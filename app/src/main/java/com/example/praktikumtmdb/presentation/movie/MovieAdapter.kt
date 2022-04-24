package com.example.praktikumtmdb.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.praktikumtmdb.data.model.movie.Movie
import com.example.praktikumtmdb.databinding.ListItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    private val movieList = ArrayList<Movie>()

     fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MovieViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.tvTitle.text = movie.title
        binding.tvDescription.text = movie.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500/" + movie.posterPath
        Glide.with(binding.ivPoster.context).load(posterUrl).into(binding.ivPoster)
    }
}