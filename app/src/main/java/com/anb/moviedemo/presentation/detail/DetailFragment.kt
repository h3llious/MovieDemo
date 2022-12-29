package com.anb.moviedemo.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.anb.moviedemo.R
import com.anb.moviedemo.databinding.FragmentDetailBinding
import com.anb.moviedemo.presentation.base.BaseFragment
import com.anb.moviedemo.presentation.uimodel.MovieUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailBinding =
        FragmentDetailBinding::inflate

    private val placeholder = MovieUiModel(
        "Tenet",
        "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
        R.drawable.tenet,
        7.8,
        "2h 30 min",
        "Action, Sci-Fi",
        "3 September 2020",
        "https://www.youtube.com/watch?v=LdOM0x0XDMo"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        bindViewEvents()
    }

    private fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            show()
            title = getString(R.string.text_movies)
        }
        with(binding) {
//            val imageIds = resources.obtainTypedArray(R.array.poster_drawable_ids)
//            imageIds.getResourceId(MoviePoster.TENET.ordinal, 0)
//            imageIds.recycle()

            ivDetailPoster.setImageResource(placeholder.posterResource)
            tvDetailTitle.text = placeholder.title
            tvDetailRating.text = placeholder.rating.toString()
            btDetailWatchlist.text =
                    // move to transform function
                getString(
                    if (placeholder.isFavorite)
                        R.string.text_detail_remove_from_watchlist
                    else
                        R.string.text_detail_add_to_watchlist
                )
            tvDetailDescriptionContent.text = placeholder.description
            tvDetailGenreContent.text = placeholder.genre
            tvDetailReleaseDateContent.text = placeholder.releaseDate
        }
    }

    private fun bindViewEvents() {
        binding.btDetailTrailer.setOnClickListener {
            val trailerIntent = Intent(Intent.ACTION_VIEW, Uri.parse(placeholder.trailer))
            startActivity(trailerIntent)
        }
        binding.btDetailWatchlist.setOnClickListener {
            // TODO
        }
    }
}
