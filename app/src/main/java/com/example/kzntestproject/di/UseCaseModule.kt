package com.example.kzntestproject.di

import com.example.kzntestproject.data.repository.SportsEventsRepository
import com.example.kzntestproject.domain.usecase.GetSportEventsUseCase
import com.example.kzntestproject.domain.usecase.impl.GetSportEventsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetSportsEventsUseCase(
        repository: SportsEventsRepository
    ): GetSportEventsUseCase {
        return GetSportEventsUseCaseImpl(repository)
    }
}