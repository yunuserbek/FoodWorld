package com.food.domain.local

import com.food.common.model.CategoryDetailUIModel

interface LocalDataSource {

    suspend fun addRecipe(recipe:CategoryDetailUIModel)

    suspend fun isRecipeSaved(recipeId:Int):CategoryDetailUIModel

    suspend fun getFavoriteRecipes():List<CategoryDetailUIModel>

    suspend fun deleteRecipeFavorite(recipe:CategoryDetailUIModel)




}