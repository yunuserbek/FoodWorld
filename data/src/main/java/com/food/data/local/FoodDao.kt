package com.food.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.food.common.model.CategoryDetailUIModel

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecipe(recipe:CategoryDetailUIModel)


    @Query("SELECT * FROM category_detail WHERE id=:recipeId")
    suspend fun isRecipeSaved(recipeId:Int):CategoryDetailUIModel

    @Query("SELECT * FROM category_detail")
    suspend fun getFavoriteRecipes():List<CategoryDetailUIModel>


}