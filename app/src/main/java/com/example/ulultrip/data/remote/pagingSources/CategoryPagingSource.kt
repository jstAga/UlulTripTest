package com.example.ulultrip.data.remote.pagingSources

import com.example.ulultrip.core.network.paging.BasePagingSource
import com.example.ulultrip.data.model.CategoryResponse
import com.example.ulultrip.data.model.CategoryModel
import com.example.ulultrip.data.remote.ApiService

class CategoryPagingSource(private val apiService: ApiService) :
    BasePagingSource<CategoryResponse, CategoryModel>({ apiService.getTourCategories(it) })