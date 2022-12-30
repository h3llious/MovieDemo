package com.anb.moviedemo.presentation.uimodel

import com.anb.moviedemo.data.room.MovieEntity
import com.anb.moviedemo.presentation.base.getFormattedTime

data class MovieUiModel(
    val id: Int,
    val title: String,
    val description: String,
    val posterId: Int,
    val rating: Double,
    val duration: String,
    val genre: String,
    val releaseDate: String,
    val trailer: String,
    val releaseYear: String,
    var isFavorite: Boolean = false
)

fun MovieEntity.toUiModel(): MovieUiModel {
    return MovieUiModel(
        id = id,
        title = title,
        description = description,
        posterId = posterId,
        rating = rating,
        duration = duration,
        genre = genre,
        releaseDate = getFormattedTime(releaseDate),
        trailer = trailer,
        releaseYear = getFormattedTime(releaseDate, "yyyy"),
        isFavorite = isFavorite
    )
}
