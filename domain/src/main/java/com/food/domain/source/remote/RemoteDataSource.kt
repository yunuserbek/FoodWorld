package com.food.domain.source.remote

import com.food.common.remote.RandomFood
import com.food.common.remote.categorydetailresponse.CategoryDetailResponse

interface RemoteDataSource {

suspend fun getRandomFood(count:Int): RandomFood

suspend fun getCategory(number:Int,category:String):RandomFood

suspend fun getDetail(id:Int):CategoryDetailResponse

}