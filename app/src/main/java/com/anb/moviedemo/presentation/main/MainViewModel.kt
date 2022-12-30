package com.anb.moviedemo.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anb.moviedemo.R
import com.anb.moviedemo.presentation.base.MoviePoster
import com.anb.moviedemo.presentation.base.SORT_TYPE_TITLE
import com.anb.moviedemo.presentation.uimodel.MovieUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val _movies = MutableLiveData<List<MovieUiModel>>(
        listOf(
            MovieUiModel(
                "Tenet",
                "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                R.drawable.tenet, // Temporary, move to fragment later
                7.8,
                "2h 30 min",
                "Action, Sci-Fi",
                "3 September 2020",
                "https://www.youtube.com/watch?v=LdOM0x0XDMo"
            )
        )
    )
    val movies: LiveData<List<MovieUiModel>>
        get() = _movies

    var sortType: Int = SORT_TYPE_TITLE
        set(value) {
            field = value
            // TODO invoke something
        }
}
