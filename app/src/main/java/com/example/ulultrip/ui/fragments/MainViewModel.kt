package com.example.ulultrip.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortytest.core.network.result.Resource
import com.example.rickandmortytest.core.ui.BaseViewModel
import com.example.ulultrip.ui.fragments.repository.TestTepository
import com.example.ulultrip.data.model.CM
import com.example.ulultrip.data.remote.ApiService
import com.example.ulultrip.data.remote.CategoryPagingSource

//class MainViewModel(private val repository: TestTepository,private val apiService: ApiService) : BaseViewModel() {
class MainViewModel(private val apiService: ApiService) : BaseViewModel() {

//    lateinit var liveCategories: LiveData<Resource<CM>>
//
//    fun getTourCategories() {
//        liveCategories = repository.getTourCategories()
//    }

    val listData = Pager(PagingConfig(pageSize = 1)) {
        CategoryPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}