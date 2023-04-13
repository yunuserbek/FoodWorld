package com.food.common.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data  class IngredientUI ( val id: Int,val original: String,val image:String)
    :Parcelable