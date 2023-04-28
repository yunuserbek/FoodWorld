package com.food.foodworld.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food.common.Resource
import com.food.common.model.SearchUIModel
import com.food.domain.usecaseImpl.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchVM @Inject constructor(private val searchUseCase: SearchUseCase):ViewModel(){
private var _getSearch = MutableStateFlow<Resource<List<SearchUIModel>>>(Resource.Loading)
    val search = _getSearch.asStateFlow()


    fun getSearch(query:String) =viewModelScope.launch {

     searchUseCase.invoke(query).collect {
         _getSearch.emit(it)
     }
    }
}