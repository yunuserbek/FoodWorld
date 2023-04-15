package com.food.data.di

import android.content.Context
import androidx.room.Room
import com.food.data.local.FoodDao
import com.food.data.local.FoodDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RomModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context:Context):FoodDatabase=
        Room.databaseBuilder(
            context,FoodDatabase::class.java,"foodDatabase.db"
        ).build()

    @Provides
    @Singleton
    fun provideFoodDao(dbDatabase:FoodDatabase): FoodDao = dbDatabase.foodDao()
}