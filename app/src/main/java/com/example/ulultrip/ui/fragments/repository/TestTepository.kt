package com.example.ulultrip.ui.fragments.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.rickandmortytest.core.network.result.Resource
import com.example.ulultrip.data.TestDataSource
import com.example.ulultrip.data.model.CM
import kotlinx.coroutines.Dispatchers


class TestTepository(private val dataSource: TestDataSource) {

    fun getTourCategories(): LiveData<Resource<CM>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getTourCategories()
        emit(response)
    }
}