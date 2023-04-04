package com.food.data.repository


import com.food.common.Resource
import com.food.common.model.RandomUIModel
import com.food.data.mapper.RandomUIModelMap
import com.food.domain.repository.FoodRepository

import com.food.domain.source.remote.RemoteDataSource
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
    ): Flow<Resource<List<RandomUIModel>>> = flow{
        emit(Resource.Loading)
        val response = try{
            remoteDataSource.getCategory(number,category)
        }catch (e:IOException){
            emit(Resource.Error(e))
            null
        }
        response?.let{response->
            emit(Resource.Success(response.recipes.RandomUIModelMap()))

    }
    }


}