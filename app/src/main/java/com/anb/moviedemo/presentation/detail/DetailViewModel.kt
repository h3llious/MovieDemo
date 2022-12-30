package com.anb.moviedemo.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anb.moviedemo.domain.usecase.GetMovieUseCase
import com.anb.moviedemo.domain.usecase.UpdateMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase,
    state: SavedStateHandle
): ViewModel() {
    private val movieId = DetailFragmentArgs.fromSavedStateHandle(state).id
    val movieData = getMovieUseCase.execute(movieId)

    fun updateMovie(isFavorite: Boolean) {
        viewModelScope.launch {
            updateMovieUseCase.execute(movieId, isFavorite)
        }
    }
}
