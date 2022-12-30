package com.anb.moviedemo.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.anb.moviedemo.R
import com.anb.moviedemo.databinding.ItemMovieBinding
import com.anb.moviedemo.presentation.uimodel.MovieUiModel

class MovieAdapter(
    private val onItemClickListener: (id: Int) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
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
                tvTitle.text = movie.title + " (${movie.releaseYear})"
                tvInfo.text = root.resources.getString(
                    R.string.text_item_movie_info,
                    movie.duration,
                    movie.genre
                )
                tvWatchlist.isVisible = movie.isFavorite
                ivItemPoster.setImageResource(getPosterResource(root.context, movie.posterId))
                root.setOnClickListener {
                    onItemClickListener.invoke(movie.id)
                }
            }
        }

        private fun getPosterResource(context: Context, position: Int): Int {
            val imageIds = context.resources.obtainTypedArray(R.array.poster_drawable_ids)
            val resource = imageIds.getResourceId(position, 0)
            imageIds.recycle()
            return resource
        }
    }
}
