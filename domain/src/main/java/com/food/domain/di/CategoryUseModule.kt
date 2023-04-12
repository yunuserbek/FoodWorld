package com.food.domain.di

import com.food.domain.usecase.CategoryDetailUseCaseInt
import com.food.domain.usecase.CategoryUseCase
import com.food.domain.usecaseImpl.CategoryDetailUseCase
import com.food.domain.usecaseImpl.CategoryRandomUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class CategoryUseModule {

    @Binds
    @Singleton
    abstract fun bindCategoryUseCase(useCase: CategoryRandomUseCase): CategoryUseCase

    @Binds
    @Singleton
    abstract fun bindCategoryDetailUseCase(useCase: CategoryDetailUseCase): CategoryDetailUseCaseInt
}