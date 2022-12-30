package com.anb.moviedemo.domain.usecase

import com.anb.moviedemo.data.room.MovieEntity
import com.anb.moviedemo.domain.repo.MovieRepository
import com.anb.moviedemo.presentation.base.MoviePoster
import javax.inject.Inject

class InsertMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend fun execute() {
        movieRepository.insertMovies(
            listOf(
                MovieEntity(
                    title = "Tenet",
                    description = "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                    rating = 7.8,
                    duration = "2h 30 min",
                    genre = "Action, Sci-Fi",
                    releaseDate = 1599139098000,
                    trailer = "https://www.youtube.com/watch?v=LdOM0x0XDMo",
                    posterId = MoviePoster.TENET.ordinal
                ),
                MovieEntity(
                    title = "Spider-Man: Into the Spider-Verse",
                    description = "Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat for all realities.",
                    rating = 8.4,
                    duration = "1h 57min",
                    genre = "Action, Animation, Adventure",
                    releaseDate = 1544793498000,
                    trailer = "https://www.youtube.com/watch?v=tg52up16eq0",
                    posterId = MoviePoster.SPIDER_MAN.ordinal
                ),
                MovieEntity(
                    title = "Knives Out",
                    description = "A detective investigates the death of a patriarch of an eccentric, combative family.",
                    rating = 7.9,
                    duration = "2h 10min",
                    genre = "Comedy, Crime, Drama",
                    releaseDate = 1574860698000,
                    trailer = "https://www.youtube.com/watch?v=qGqiHJTsRkQ",
                    posterId = MoviePoster.KNIVES_OUT.ordinal
                ),
                MovieEntity(
                    title = "Guardians of the Galaxy",
                    description = "A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe.",
                    rating = 8.0,
                    duration = "2h 1min",
                    genre = "Action, Adventure, Comedy",
                    releaseDate = 1406899098000,
                    trailer = "https://www.youtube.com/watch?v=d96cjJhvlMA",
                    posterId = MoviePoster.GUARDIANS_OF_THE_GALAXY.ordinal
                ),
                MovieEntity(
                    title = "Avengers: Age of Ultron",
                    description = "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan.",
                    rating = 7.3,
                    duration = "2h 21min",
                    genre = "Action, Adventure, Sci-Fi",
                    releaseDate = 1430486298000,
                    trailer = "https://www.youtube.com/watch?v=tmeOjFno6Do",
                    posterId = MoviePoster.AVENGERS.ordinal
                )
            )
        )
    }
}
