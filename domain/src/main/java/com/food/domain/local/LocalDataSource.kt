package com.food.domain.local

import com.food.common.model.CategoryDetailUIModel

interface LocalDataSource {

    suspend fun addRecipe(recipe:CategoryDetailUIModel)
}