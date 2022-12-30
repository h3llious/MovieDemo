package com.anb.moviedemo.presentation.detail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.anb.moviedemo.R
import com.anb.moviedemo.databinding.FragmentDetailBinding
import com.anb.moviedemo.presentation.base.BaseFragment
import com.anb.moviedemo.presentation.uimodel.MovieUiModel
import com.anb.moviedemo.presentation.uimodel.toUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailBinding =
        FragmentDetailBinding::inflate

    private val viewModel: DetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        bindViewModel()
        bindViewEvents()
    }

    private fun bindViewModel() {
        viewModel.movieData.observe(viewLifecycleOwner) {
            initMovieData(it.toUiModel())
        }
    }

    private fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            show()
            title = getString(R.string.text_movies)
        }
    }

    private fun bindViewEvents() {
        binding.btDetailWatchlist.setOnClickListener {
            viewModel.updateMovie(!(viewModel.movieData.value?.isFavorite ?: false))
        }
    }

    private fun initMovieData(movie: MovieUiModel) {
        with(binding) {
            ivDetailPoster.setImageResource(getPosterResource(requireContext(), movie.posterId))
            tvDetailTitle.text = movie.title
            tvDetailRating.text = movie.rating.toString()
            btDetailWatchlist.text =
                getString(
                    if (movie.isFavorite)
                        R.string.text_detail_remove_from_watchlist
                    else
                        R.string.text_detail_add_to_watchlist
                )
            tvDetailDescriptionContent.text = movie.description
            tvDetailGenreContent.text = movie.genre
            tvDetailReleaseDateContent.text = movie.releaseDate
            btDetailTrailer.setOnClickListener {
                val trailerIntent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.trailer))
                startActivity(trailerIntent)
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
