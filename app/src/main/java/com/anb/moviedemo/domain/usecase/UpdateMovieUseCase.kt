package com.anb.moviedemo.domain.usecase

import com.anb.moviedemo.domain.repo.MovieRepository
import javax.inject.Inject

class UpdateMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend fun execute(id: Int, isFavorite: Boolean) {
        movieRepository.updateFavorite(id, isFavorite)
    }
}
