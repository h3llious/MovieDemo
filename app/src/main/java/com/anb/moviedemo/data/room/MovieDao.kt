package com.anb.moviedemo.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie ORDER BY "+
            "      CASE :sort WHEN 'title' THEN title END DESC," +
            "      CASE :sort WHEN 'releaseDate' THEN releaseDate END DESC")
    suspend fun getAllMovies(sort: String): List<MovieEntity>

    @Query("SELECT * from movie WHERE id = :id")
    fun getMovie(id: Int): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(items: List<MovieEntity>)

    @Query("UPDATE movie SET isFavorite = :isFavorite WHERE id =:id")
    suspend fun updateMovie(isFavorite: Boolean, id: Int)
}
