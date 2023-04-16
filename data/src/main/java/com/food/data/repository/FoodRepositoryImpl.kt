package com.food.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import com.food.common.model.RandomUIModel
import com.food.data.mapper.RandomUIModelMap
import com.food.data.mapper.toDetailMapper
import com.food.domain.local.LocalDataSource
import com.food.domain.repository.FoodRepository

import com.food.domain.source.remote.RemoteDataSource
import com.food.paging.FoodPagingSource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(

    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
    ) :
    FoodRepository {
    override fun getFood(count:Int): Flow<Resource<List<RandomUIModel>>> = flow {
        emit(Resource.Loading)
        val response = try {
            remoteDataSource.getRandomFood(count)
        }catch (e:IOException){
            emit(Resource.Error(e))
            null
        }
        response?.let { data ->
            emit(Resource.Success(data.recipes.RandomUIModelMap()))


        }

    }

    override fun getFoodByCategory(
        number: Int,
        category: String
    ): Flow<PagingData<RandomUIModel>> =flow{

        Pager(config = PagingConfig(number, maxSize = 100, enablePlaceholders = false),
        pagingSourceFactory = {
            FoodPagingSource(remoteDataSource, size = number,category)

        }).flow.collect {
            emit(it)
        }




    }

    override fun getCategoryDetail(id: Int): Flow<Resource<CategoryDetailUIModel>> = flow{
        emit(Resource.Loading)
        val response = try {
            remoteDataSource.getDetail(id)
        }catch (e:IOException){
            emit(Resource.Error(e))
            null
        }
        response?.let { data ->
            emit(Resource.Success(data.toDetailMapper()))
        }
    }

    override suspend fun addRecipe(recipe: CategoryDetailUIModel) {
        localDataSource.addRecipe(recipe)
    }

    override fun isRecipeSaved(recipeId: Int): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading)
        val response = try {
            localDataSource.isRecipeSaved(recipeId)
        } catch (e: IOException) {
            emit(Resource.Error(e))
            null
        }
        response?.let {
            emit(Resource.Success(true))
        } ?: kotlin.run { emit(Resource.Success(false)) }
    }

    override  fun getFavoriteRecipes(): Flow<Resource<List<CategoryDetailUIModel>>> = flow {
        emit(Resource.Loading)
    val response =try {
        localDataSource.getFavoriteRecipes()
    }catch (e:IOException){
        emit(Resource.Error(e))
        null
    }
        response?.let {
            emit(Resource.Success(it))
        }
    }

    }


