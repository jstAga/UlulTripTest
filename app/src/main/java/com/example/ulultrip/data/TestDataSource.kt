package com.example.ulultrip.data

import com.example.ulultrip.core.network.BaseDataSource
import com.example.ulultrip.data.model.CategoryResponse
import com.example.ulultrip.data.remote.ApiService
import com.geektech.youtubeapi.core.network.result.Resource
import org.koin.core.module.Module
import org.koin.dsl.module

val testDataSource: Module = module {
    factory { TestDataSource(get()) }
}


class TestDataSource(private val apiService: ApiService) : BaseDataSource() {

    suspend fun getTourCategories(): Resource<CategoryResponse> = getResult { apiService.getTourCategories() }
}