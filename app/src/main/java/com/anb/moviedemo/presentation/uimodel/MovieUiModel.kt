package com.anb.moviedemo.presentation.uimodel

import androidx.annotation.DrawableRes
import com.anb.moviedemo.presentation.base.MoviePoster

data class MovieUiModel(
    val title: String,
    val description: String,
    val posterEnum: MoviePoster,
    val rating: Double,
    val duration: String,
    val genre: String,
    val releaseDate: String,
    val trailer: String,
    var isFavorite: Boolean = false
)
