package com.food.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.food.common.Converters
import com.food.common.model.CategoryDetailUIModel

@Database(entities = [CategoryDetailUIModel::class], version = 1, exportSchema = false)

@TypeConverters(Converters::class)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao

    }
