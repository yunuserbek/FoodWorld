package com.food.foodworld.data.source.remote

import com.food.foodworld.common.Constants.RANDOM
import com.food.foodworld.data.remote.RandomFood
import retrofit2.http.GET


interface FoodServices {

    @GET(RANDOM)
    suspend fun getRandomFood():RandomFood

}