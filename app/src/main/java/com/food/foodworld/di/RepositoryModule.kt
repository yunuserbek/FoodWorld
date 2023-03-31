package com.food.foodworld.di

import com.food.foodworld.data.repository.FoodRepositoryImpl
import com.food.foodworld.domain.repository.FoodRepository
import com.food.foodworld.domain.source.remote.RemoteDataSource
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
    fun providesFoodRepository(remoteDataSource: RemoteDataSource):FoodRepository = FoodRepositoryImpl(remoteDataSource)

}