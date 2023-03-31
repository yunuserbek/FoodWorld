package com.food.foodworld.data.source.remote

import com.food.foodworld.common.Constants.RANDOM
import com.food.foodworld.data.remote.RandomFood
import retrofit2.http.GET
import retrofit2.http.Query


interface FoodServices {

    @GET(RANDOM)
    suspend fun getRandomFood(
        @Query("number") count: Int
    ):RandomFood

}