package com.food.data.di

import com.food.data.repository.FoodRepositoryImpl
import com.food.domain.repository.FoodRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun providesFoodRepository(repositoryImpl: FoodRepositoryImpl): FoodRepository
}