package com.food.data.mapper

import com.food.common.model.CategoryDetailUIModel
import com.food.common.model.IngredientUI
import com.food.common.model.RandomUIModel
import com.food.common.remote.Recipe
import com.food.common.remote.categorydetailresponse.CategoryDetailResponse
import com.food.common.remote.categorydetailresponse.ExtendedIngredient


fun List<Recipe>.RandomUIModelMap() = map {
    RandomUIModel(
        id = it.id?:0,
        image = it.image?:"",
        title = it.title?:"",
        healthScore = it.healthScore ?: 0,
        vegan = it.vegan ?: false,
        readyInMinutes = it.readyInMinutes ?: 0
    )
}

fun CategoryDetailResponse.toDetailMapper()= CategoryDetailUIModel(
    id = id?:0,
    title = title?:"",
    dairyFree = dairyFree?:false,
    glutenFree = glutenFree?:false,
    aggregateLikes = aggregateLikes?:0,
    veryHealthy = veryHealthy?:false,
    vegetarian = vegetarian?:false,
    veryPopular = veryPopular?:false,
    cheap = cheap?:false,
    healthScore = healthScore?:0,
    image = image?:"",
    sourceUrl = sourceUrl?:"",
    instructions = instructions?:"",
    extendedIngredients = extendedIngredients!!.map { it!!.toEx() }

)
fun ExtendedIngredient.toEx() =IngredientUI(
    id = id?:0,
    original =  original?:"",
)
