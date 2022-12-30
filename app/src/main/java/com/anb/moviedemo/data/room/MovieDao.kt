package com.anb.moviedemo.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie ORDER BY :sort")
    fun getAllMovies(sort: String): LiveData<List<MovieEntity>>

    @Query("SELECT * from movie WHERE id = :id")
    fun getItem(id: Int): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(items: List<MovieEntity>)

    @Query("UPDATE movie SET isfavorite = :isFavorite WHERE id =:id")
    suspend fun updateMovie(isFavorite: Boolean, id: Int)
}
