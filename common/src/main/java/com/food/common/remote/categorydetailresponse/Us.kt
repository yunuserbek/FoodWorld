package com.food.common.remote.categorydetailresponse


import com.google.gson.annotations.SerializedName

data class Us(
    @SerializedName("amount")
    val amount: Double?,
    @SerializedName("unitLong")
    val unitLong: String?,
    @SerializedName("unitShort")
    val unitShort: String?
)