package com.food.common

import androidx.room.TypeConverter
import com.food.common.model.IngredientUI
import com.food.common.model.StepUI
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromIngredient(item: List<IngredientUI>): String {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun toIngredient(item: String): List<IngredientUI> {
        val objectType = object : TypeToken<List<IngredientUI>>() {}.type
        return Gson().fromJson(item, objectType)
    }

    @TypeConverter
    fun fromStep(item: List<StepUI>): String {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun toStep(item: String): List<StepUI> {
        val objectType = object : TypeToken<List<StepUI>>() {}.type
        return Gson().fromJson(item, objectType)
    }
}