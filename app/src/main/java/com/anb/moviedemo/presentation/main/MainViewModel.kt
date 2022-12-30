package com.anb.moviedemo.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anb.moviedemo.data.room.MovieEntity
import com.anb.moviedemo.domain.usecase.GetAllMoviesUseCase
import com.anb.moviedemo.presentation.base.SORT_TYPE_TITLE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
): ViewModel() {

    private val _movies = MutableLiveData<List<MovieEntity>>()
    val movies: LiveData<List<MovieEntity>>
        get() = _movies

    var sortType: Int = SORT_TYPE_TITLE
        set(value) {
            field = value
            getAllMovies()
        }

    fun getAllMovies() {
        viewModelScope.launch {
            _movies.value = getAllMoviesUseCase.execute(sortType)
        }
    }
}
