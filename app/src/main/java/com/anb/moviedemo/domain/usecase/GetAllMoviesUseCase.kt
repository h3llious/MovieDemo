package com.anb.moviedemo.domain.usecase

import com.anb.moviedemo.data.room.MovieEntity
import com.anb.moviedemo.domain.repo.MovieRepository
import com.anb.moviedemo.presentation.base.SORT_TYPE_TITLE
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend fun execute(sortType: Int): List<MovieEntity> {
        return movieRepository.getAllMovies(
            if (sortType == SORT_TYPE_TITLE) {
                "title"
            } else {
                "releaseDate"
            }
        )
    }
}
