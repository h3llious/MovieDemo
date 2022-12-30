package com.anb.moviedemo.data.repo

import androidx.lifecycle.LiveData
import com.anb.moviedemo.data.room.MovieDatabase
import com.anb.moviedemo.data.room.MovieEntity
import com.anb.moviedemo.domain.repo.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val database: MovieDatabase
): MovieRepository {
    override suspend fun insertMovies(items: List<MovieEntity>) {
        withContext(Dispatchers.IO) {
            database.movieDao().insertMovies(items)
        }
    }

    override suspend fun getAllMovies(sort: String): List<MovieEntity> {
        return withContext(Dispatchers.IO){
            database.movieDao().getAllMovies(sort)
        }
    }

    override fun getMovie(id: Int): LiveData<MovieEntity> {
        return database.movieDao().getMovie(id)
    }

    override suspend fun updateFavorite(id: Int, isFavorite: Boolean) {
        withContext(Dispatchers.IO) {
            database.movieDao().updateMovie(isFavorite, id)
        }
    }
}
