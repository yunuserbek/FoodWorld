package com.food.domain.di

import com.food.domain.usecase.AddRecipeUseCaseInt
import com.food.domain.usecase.CategoryDetailUseCaseInt
import com.food.domain.usecase.CategoryUseCase
import com.food.domain.usecase.SearchUseCaseInt
import com.food.domain.usecaseImpl.AddRecipeUseCase
import com.food.domain.usecaseImpl.CategoryDetailUseCase
import com.food.domain.usecaseImpl.CategoryRandomUseCase
import com.food.domain.usecaseImpl.SearchUseCase
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

    @Binds
    @Singleton
    abstract fun bindAddRecipeUseCase(useCase: AddRecipeUseCase): AddRecipeUseCaseInt

    @Binds
    @Singleton
    abstract fun bindSearchUseCase(useCase:SearchUseCase): SearchUseCaseInt
}