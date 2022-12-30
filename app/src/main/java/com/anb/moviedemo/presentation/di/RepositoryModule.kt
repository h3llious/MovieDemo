package com.anb.moviedemo.presentation.di

import com.anb.moviedemo.data.repo.MovieRepositoryImpl
import com.anb.moviedemo.domain.repo.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(impl: MovieRepositoryImpl): MovieRepository {
        return impl
    }
}
