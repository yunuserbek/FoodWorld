package com.food.foodworld.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food.common.Resource
import com.food.common.model.SearchUIModel
import com.food.data.mapper.randomToSearchResultUI
import com.food.data.mapper.toMapSearch
import com.food.domain.usecaseImpl.CategoryRandomUseCase
import com.food.domain.usecaseImpl.RandomFoodUseCase
import com.food.domain.usecaseImpl.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchVM @Inject constructor(private val searchUseCase: SearchUseCase,private val randomUseCase: RandomFoodUseCase):ViewModel(){
private var _getSearch = MutableStateFlow<Resource<List<SearchUIModel>>>(Resource.Loading)
    val search = _getSearch.asStateFlow()

    init {
        geRandom()
    }

    fun getSearch(query:String) =viewModelScope.launch {

     searchUseCase.invoke(query).collect {
         _getSearch.emit(it)
     }
    }
    fun geRandom()=viewModelScope.launch{

        randomUseCase.invoke(50).collect{
            when(it){
                is Resource.Success->{
                    val data = it.data.map { it.toMapSearch() }

                    _getSearch.emit(Resource.Success(data))
                }
                is Resource.Error->{
                    _getSearch.emit(it)
                }
                is Resource.Loading->{
                    _getSearch.emit(it)
                }
            }

        }
    }

}