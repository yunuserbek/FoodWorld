package com.food.common.remote


import com.food.common.remote.Equipment
import com.food.common.remote.Ingredient
import com.food.common.remote.Length
import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("equipment")
    val equipment: List<Equipment?>?,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient?>?,
    @SerializedName("length")
    val length: Length?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("step")
    val step: String?
)