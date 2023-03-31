package com.food.foodworld.di

import com.food.foodworld.data.source.remote.FoodServices
import com.food.foodworld.data.source.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(foodServices: FoodServices) = RemoteDataSourceImpl(foodServices)



}