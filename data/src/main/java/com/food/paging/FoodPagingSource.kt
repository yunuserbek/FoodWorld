package com.food.paging

import androidx.paging.LoadState
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.food.common.model.RandomUIModel
import com.food.data.mapper.RandomUIModelMap
import com.food.domain.source.remote.RemoteDataSource

class FoodPagingSource(
    private val remoteDataSource: RemoteDataSource,
    private val size: Int,
    private val categoryItem: String
) : PagingSource<Int, RandomUIModel>() {
    override fun getRefreshKey(state: PagingState<Int, RandomUIModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RandomUIModel> {
        return try {

            val currenPage = params.key ?: 1
            val response = remoteDataSource.getCategory(size, categoryItem)
            LoadResult.Page(
                data = response.recipes.RandomUIModelMap(),
                prevKey =if (currenPage == 1) null else -1,
                nextKey =  currenPage.plus(1)

            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }


}