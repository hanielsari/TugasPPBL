package com.example.praktikumtmdb.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.praktikumtmdb.data.model.artist.Artist
import com.example.praktikumtmdb.data.model.movie.Movie
import com.example.praktikumtmdb.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>() {
    private val artistList = ArrayList<Artist>()

    fun setList(artist: List<Artist>) {
        artistList.clear()
        artistList.addAll(artist)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class ArtistViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        binding.tvTitle.text = artist.name
        binding.tvDescription.text = artist.popularity.toString()
        val posterUrl = "https://image.tmdb.org/t/p/w500/" + artist.profilePath
        Glide.with(binding.ivPoster.context).load(posterUrl).into(binding.ivPoster)
    }
}
