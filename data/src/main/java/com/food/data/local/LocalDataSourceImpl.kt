package com.food.data.local

import com.food.common.model.CategoryDetailUIModel
import com.food.domain.local.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor (private val foodDao:FoodDao): LocalDataSource{
    override suspend fun addRecipe(recipe: CategoryDetailUIModel) =foodDao.addRecipe(recipe)
    override suspend fun isRecipeSaved(recipeId: Int): CategoryDetailUIModel = foodDao.isRecipeSaved(recipeId)
    override suspend fun getFavoriteRecipes(): List<CategoryDetailUIModel> =foodDao.getFavoriteRecipes()
    override suspend fun deleteRecipeFavorite(recipe: CategoryDetailUIModel) = foodDao.deleteRecipeFavorite(recipe)


}