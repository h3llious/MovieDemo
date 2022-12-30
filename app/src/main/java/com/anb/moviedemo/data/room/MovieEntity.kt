package com.anb.moviedemo.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val posterId: Int,
    val rating: Double,
    val duration: String,
    val genre: String,
    val releaseDate: Long,
    val trailer: String,
    var isFavorite: Boolean = false
)
