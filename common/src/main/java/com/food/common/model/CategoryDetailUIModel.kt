package com.food.common.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "category_detail")
data  class CategoryDetailUIModel(
@PrimaryKey(autoGenerate = false)

    val id: Int,
    val title: String,
    val dairyFree: Boolean,
    val glutenFree: Boolean,
    val aggregateLikes: Int? = null,
    val veryHealthy: Boolean,
    val vegetarian: Boolean,
    val veryPopular: Boolean,
    val cheap: Boolean,
    val extendedIngredients: List<IngredientUI>,
    val healthScore: Int,
    val image: String,
    val sourceUrl: String,
    val instructions: String? = null,
    val step: List<StepUI> = emptyList(),
var imageFilePath: String?

    ):Parcelable
