package com.example.praktikumtmdb.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.praktikumtmdb.data.model.tvshow.TvShow
import com.example.praktikumtmdb.databinding.ListItemBinding


class TvShowAdapter : RecyclerView.Adapter<TvShowHolder>() {
    private val tvshowList = ArrayList<TvShow>()

    fun setList(tvshow: List<TvShow>) {
        tvshowList.clear()
        tvshowList.addAll(tvshow)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return TvShowHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        holder.bind(tvshowList[position])
    }

    override fun getItemCount(): Int {
        return tvshowList.size
    }
}

class TvShowHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tvshow: TvShow) {
        binding.tvTitle.text = tvshow.name
        binding.tvDescription.text = tvshow.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500/" + tvshow.posterPath
        Glide.with(binding.ivPoster.context).load(posterUrl).into(binding.ivPoster)
    }
}