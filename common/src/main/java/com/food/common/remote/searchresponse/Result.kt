package com.food.common.remote.searchresponse


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("imageType")
    val imageType: String?,
    @SerializedName("title")
    val title: String?
)