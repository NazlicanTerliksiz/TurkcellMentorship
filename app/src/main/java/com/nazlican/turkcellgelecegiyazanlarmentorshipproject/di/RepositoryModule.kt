package com.nazlican.turkcellgelecegiyazanlarmentorshipproject.di

import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.repo.HomeRepository
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.source.remote.SimpsonsQuoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule{
    @Provides
    @Singleton
    fun provideHomeRepository(simpsonsQuoteService: SimpsonsQuoteService) = HomeRepository(simpsonsQuoteService)
}