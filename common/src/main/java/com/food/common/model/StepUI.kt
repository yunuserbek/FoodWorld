package com.food.common.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "StepUI")
data class StepUI ( val step:String):Parcelable