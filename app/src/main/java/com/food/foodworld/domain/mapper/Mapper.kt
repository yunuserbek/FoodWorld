package com.food.foodworld.domain.mapper

import com.food.foodworld.data.remote.Recipe
import com.food.foodworld.domain.model.RandomUIModel


fun List<Recipe>.RandomUIModelMap() = map {
    RandomUIModel(
        id = it.id?:0,
        image = it.image?:"",
        title = it.title?:"",
        healthScore = it.healthScore ?: 0
    )
}