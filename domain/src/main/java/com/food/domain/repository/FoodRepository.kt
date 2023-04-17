package com.food.domain.repository
import androidx.paging.PagingData
import androidx.room.Query
import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import com.food.common.model.RandomUIModel
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
fun getFood(count:Int): Flow<Resource<List<RandomUIModel>>>

fun getFoodByCategory(number:Int,category:String):Flow<PagingData<RandomUIModel>>

fun getCategoryDetail(id:Int):Flow<Resource<CategoryDetailUIModel>>

suspend fun addRecipe(recipe: CategoryDetailUIModel)

fun isRecipeSaved(recipeId:Int):Flow<Resource<Boolean>>


fun getFavoriteRecipes():Flow<Resource<List<CategoryDetailUIModel>>>

suspend fun deleteFavoriteRecipe(recipeId: CategoryDetailUIModel)

}