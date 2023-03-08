package com.example.ulultrip.ui.fragments.main.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.ulultrip.data.TestDataSource
import com.example.ulultrip.data.model.CategoryResponse
import com.geektech.youtubeapi.core.network.result.Resource
import kotlinx.coroutines.Dispatchers


class MainRepository(private val dataSource: TestDataSource) {

    fun getTourCategories(): LiveData<Resource<CategoryResponse>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getTourCategories()
        emit(response)
    }
}