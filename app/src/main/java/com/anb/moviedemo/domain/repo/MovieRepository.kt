package com.anb.moviedemo.domain.repo

import androidx.lifecycle.LiveData
import com.anb.moviedemo.data.room.MovieEntity

interface MovieRepository {
    suspend fun insertMovies(items: List<MovieEntity>)

    suspend fun getAllMovies(sort: String): List<MovieEntity>

    fun getMovie(id: Int): LiveData<MovieEntity>

    suspend fun updateFavorite(id: Int, isFavorite: Boolean)
}
