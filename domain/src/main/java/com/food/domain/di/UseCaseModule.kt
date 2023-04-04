package com.food.domain.di

import com.food.domain.usecaseImpl.RandomFoodUseCase
import com.food.domain.usecase.RandomUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindRandomUseCase(useCase: RandomFoodUseCase): RandomUseCase}


