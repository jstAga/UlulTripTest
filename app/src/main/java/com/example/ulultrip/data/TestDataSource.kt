package com.example.ulultrip.data

import com.example.ulultrip.core.network.BaseDataSource
import com.example.rickandmortytest.core.network.result.Resource
import com.example.ulultrip.data.model.CM
import com.example.ulultrip.data.remote.ApiService
import org.koin.core.module.Module
import org.koin.dsl.module

val testDataSource: Module = module {
    factory { TestDataSource(get()) }
}


class TestDataSource(private val apiService: ApiService) : BaseDataSource() {

    suspend fun getTourCategories(): Resource<CM> = getResult { apiService.getTourCategories() }
}