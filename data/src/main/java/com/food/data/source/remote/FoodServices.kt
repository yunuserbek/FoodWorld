package com.food.data.source.remote

import com.food.data.common.Constants.RANDOM
import com.food.common.remote.RandomFood
import com.food.common.remote.categorydetailresponse.CategoryDetailResponse
import com.food.data.common.Constants.INFORMATION
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface FoodServices {

    @GET(RANDOM)
    suspend fun getRandomFood(
        @Query("number") count: Int
    ): RandomFood

    @GET(RANDOM)
    suspend fun getCategory(
        @Query("number") count: Int,
        @Query("tags") category: String
    ): RandomFood

    @GET(INFORMATION)
    suspend fun getDetailCategory(
        @Path("id")id:Int
    ): CategoryDetailResponse
    
}