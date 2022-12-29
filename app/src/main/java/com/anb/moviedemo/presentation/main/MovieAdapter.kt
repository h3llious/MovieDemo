package com.anb.moviedemo.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.anb.moviedemo.R
import com.anb.moviedemo.databinding.ItemMovieBinding
import com.anb.moviedemo.presentation.uimodel.MovieUiModel

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movieList = listOf<MovieUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        if (position >= 0 && position < movieList.size) {
            holder.bind(movieList[position])
        }
    }

    override fun getItemCount() = movieList.size

    fun setMovieList(list: List<MovieUiModel>) {
        movieList = list
        // Consider using DiffUtil if there are more items
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(
        private val view: ItemMovieBinding
    ) : RecyclerView.ViewHolder(view.root) {

        fun bind(movie: MovieUiModel) {
            with(view) {
                tvTitle.text = movie.title
                tvInfo.text = root.resources.getString(
                    R.string.text_item_movie_info,
                    movie.duration,
                    movie.genre
                )
                tvWatchlist.isVisible = movie.isFavorite
//                ivItemPoster.setImageResource(root.resources.getIntArray(R.array.poster_drawable_ids)[movie.posterEnum.ordinal])
                ivItemPoster.setImageResource(R.drawable.tenet)
            }
        }
    }
}
