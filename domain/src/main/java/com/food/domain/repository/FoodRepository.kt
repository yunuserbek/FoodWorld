package com.food.domain.repository
import com.food.common.Resource
import com.food.common.model.RandomUIModel
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
fun getFood(count:Int): Flow<Resource<List<RandomUIModel>>>

fun getFoodByCategory(number:Int,category:String):Flow<Resource<List<RandomUIModel>>>

}