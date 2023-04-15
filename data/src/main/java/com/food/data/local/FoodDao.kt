package com.food.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.food.common.model.CategoryDetailUIModel

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecipe(recipe:CategoryDetailUIModel)

}