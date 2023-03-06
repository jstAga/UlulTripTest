package com.example.ulultrip.ui.fragments.main

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortytest.core.ui.BaseViewModel
import com.example.ulultrip.data.remote.ApiService
import com.example.ulultrip.data.remote.pagingSources.CategoryPagingSource

class MainViewModel(private val apiService: ApiService) : BaseViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        CategoryPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}


//class MainViewModel(private val repository: TestTepository,private val apiService: ApiService) : BaseViewModel() {
//    lateinit var liveCategories: LiveData<Resource<CM>>
//
//    fun getTourCategories() {
//        liveCategories = repository.getTourCategories()
//    }