package com.example.ulultrip.ui.fragments.tours.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.ulultrip.data.model.FilterModel
import com.example.ulultrip.data.remote.ApiService
import com.example.ulultrip.data.remote.pagingSources.ToursPagingSource

class ToursRepository(private val apiService: ApiService) {

    fun getTours(filterModel: FilterModel) = Pager(
        pagingSourceFactory = { ToursPagingSource(apiService = apiService, filterModel) },
        config = PagingConfig(pageSize = 10)
    ).flow
}