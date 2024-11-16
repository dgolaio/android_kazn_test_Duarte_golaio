package com.example.kzntestproject.di

import com.example.kzntestproject.data.api.ApiService
import com.example.kzntestproject.data.repository.SportsEventsRepository
import com.example.kzntestproject.data.repository.impl.SportsEventsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSportsEventsRepository(
        apiService: ApiService
    ): SportsEventsRepository {
        return SportsEventsRepositoryImpl(apiService)
    }

}