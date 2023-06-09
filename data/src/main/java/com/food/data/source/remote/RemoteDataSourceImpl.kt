package com.food.data.source.remote

import com.food.common.remote.RandomFood
import com.food.common.remote.categorydetailresponse.CategoryDetailResponse
import com.food.common.remote.searchresponse.SearchResponse
import com.food.domain.source.remote.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor (private val foodServices: FoodServices) :
    RemoteDataSource {
    override suspend fun getRandomFood(count:Int): RandomFood = foodServices.getRandomFood(count)
    override suspend fun getCategory(number: Int, category: String): RandomFood= foodServices.getCategory(number,category)
    override suspend fun getDetail(id: Int): CategoryDetailResponse =foodServices.getDetailCategory(id)
    override suspend fun searchRecipe(
        query: String,
        diets: String,
        cuisine: String,
        intolerance: String,
        type: String
    ): SearchResponse = foodServices.searchFood(query,50,diets,cuisine,intolerance,type)

}