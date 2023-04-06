package com.food.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.food.common.Resource
import com.food.common.model.RandomUIModel
import com.food.data.mapper.RandomUIModelMap
import com.food.domain.repository.FoodRepository

import com.food.domain.source.remote.RemoteDataSource
import com.food.paging.FoodPagingSource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
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


}