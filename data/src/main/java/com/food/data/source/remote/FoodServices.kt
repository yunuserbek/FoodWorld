package com.food.data.source.remote

import com.food.data.common.Constants.RANDOM
import com.food.common.remote.RandomFood
import com.food.common.remote.categorydetailresponse.CategoryDetailResponse
import com.food.common.remote.searchresponse.SearchResponse
import com.food.data.common.Constants.INFORMATION
import com.food.data.common.Constants.SEARCH
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

    @GET(SEARCH)
    suspend fun searchFood(
        @Query("query") query: String,
        @Query("number") size: Int,
        @Query("diets") diets: String,
        @Query("cuisines") cuisine: String,
        @Query("intolerances") intolerance: String,
        @Query("type") type: String
    ):SearchResponse
}