package com.food.data.source.remote

import com.food.data.common.Constants.RANDOM
import com.food.common.remote.RandomFood
import retrofit2.http.GET
import retrofit2.http.Query


interface FoodServices {

    @GET(RANDOM)
    suspend fun getRandomFood(
        @Query("number") count: Int
    ): RandomFood

}