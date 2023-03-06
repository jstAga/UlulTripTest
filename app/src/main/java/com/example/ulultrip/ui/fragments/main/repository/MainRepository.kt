package com.example.ulultrip.ui.fragments.main.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.ulultrip.data.TestDataSource
import com.example.ulultrip.data.model.CategoryResponse
import com.example.ulultrip.data.model.FilterModel
import com.example.ulultrip.data.remote.ApiService
import com.example.ulultrip.data.remote.pagingSources.ToursPagingSource2
import com.geektech.youtubeapi.core.network.result.Resource
import kotlinx.coroutines.Dispatchers


class MainRepository(private val dataSource: TestDataSource) {

    fun getTourCategories(): LiveData<Resource<CategoryResponse>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getTourCategories()
        emit(response)
    }
}