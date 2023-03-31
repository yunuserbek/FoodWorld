package com.food.foodworld.data.remote


import com.google.gson.annotations.SerializedName

data class RandomFood(
    @SerializedName("recipes")
    val recipes: List<Recipe>
)