package com.food.common.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "IngredientUI")
data  class IngredientUI (

    val id: Int,
    val original: String,
    val image:String,
    val name:String)
    :Parcelable