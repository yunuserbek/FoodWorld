package com.food.data.mapper

import com.food.common.model.RandomUIModel
import com.food.common.remote.Recipe


fun List<Recipe>.RandomUIModelMap() = map {
    RandomUIModel(
        id = it.id?:0,
        image = it.image?:"",
        title = it.title?:"",
        healthScore = it.healthScore ?: 0
    )
}