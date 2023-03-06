package com.example.ulultrip.ui.fragments.tours.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.ulultrip.data.model.FilterModel
import com.example.ulultrip.data.remote.ApiService
import com.example.ulultrip.data.remote.pagingSources.ToursPagingSource2

class ToursRepository(private val apiService: ApiService) {

    fun getTours(filterModel: FilterModel) = Pager(
        pagingSourceFactory = { ToursPagingSource2(apiService = apiService, filterModel) },
        config = PagingConfig(pageSize = 1)
    ).flow
}