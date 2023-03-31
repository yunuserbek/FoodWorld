package com.food.foodworld.data.repository


import com.food.foodworld.common.Resource
import com.food.foodworld.domain.mapper.RandomUIModelMap
import com.food.foodworld.domain.model.RandomUIModel
import com.food.foodworld.domain.repository.FoodRepository
import com.food.foodworld.domain.source.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : FoodRepository {
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


}