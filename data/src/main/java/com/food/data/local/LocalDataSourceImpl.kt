package com.food.data.local

import com.food.common.model.CategoryDetailUIModel
import com.food.domain.local.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor (private val foodDao:FoodDao): LocalDataSource{
    override suspend fun addRecipe(recipe: CategoryDetailUIModel) =foodDao.addRecipe(recipe)

}