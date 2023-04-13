package com.food.common.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data  class CategoryDetailUIModel (

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
   // val step: List<StepUI>? = null,
    val healthScore: Int,
    val image: String,
    val sourceUrl: String,
    val instructions: String? = null,


        ):Parcelable
