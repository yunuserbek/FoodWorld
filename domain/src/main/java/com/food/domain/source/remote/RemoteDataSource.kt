package com.food.domain.source.remote

import com.food.common.remote.RandomFood
import com.food.common.remote.categorydetailresponse.CategoryDetailResponse
import com.food.common.remote.searchresponse.SearchResponse

interface RemoteDataSource {

suspend fun getRandomFood(count:Int): RandomFood

suspend fun getCategory(number:Int,category:String):RandomFood

suspend fun getDetail(id:Int):CategoryDetailResponse

suspend fun searchRecipe(
    query: String,
    diets: String,
    cuisine: String,
    intolerance: String,
    type: String
): SearchResponse

}