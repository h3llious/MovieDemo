package com.anb.moviedemo.domain.usecase

import androidx.lifecycle.LiveData
import com.anb.moviedemo.data.room.MovieEntity
import com.anb.moviedemo.domain.repo.MovieRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    fun execute(id: Int): LiveData<MovieEntity> {
        return movieRepository.getMovie(id)
    }
}
