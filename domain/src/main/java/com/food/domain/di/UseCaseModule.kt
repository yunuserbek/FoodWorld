package com.food.domain.di

import com.food.domain.usecase.DeleteIdUseCaseInt
import com.food.domain.usecase.FoodFavoriteUseCaseInt
import com.food.domain.usecase.IsRecipeSavedUseCaseInt
import com.food.domain.usecaseImpl.RandomFoodUseCase
import com.food.domain.usecase.RandomUseCase
import com.food.domain.usecaseImpl.DeleteIdUseCase
import com.food.domain.usecaseImpl.FoodFavoriteUseCase
import com.food.domain.usecaseImpl.IsRecipeSavedUse
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
    abstract fun bindRandomUseCase(useCase: RandomFoodUseCase): RandomUseCase

    @Binds
    @Singleton
    abstract fun bindIsRecipeSavedUseCase(useCase: IsRecipeSavedUse): IsRecipeSavedUseCaseInt

    @Binds
    @Singleton
    abstract fun bindFoodFavoriteUseCase(useCase: FoodFavoriteUseCase): FoodFavoriteUseCaseInt

    @Binds
    abstract fun binDeleteIdUseCase(useCase: DeleteIdUseCase): DeleteIdUseCaseInt
}




