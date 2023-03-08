package com.example.ulultrip.data.remote.pagingSources

import com.example.ulultrip.core.network.paging.BasePagingSource
import com.example.ulultrip.data.model.FilterModel
import com.example.ulultrip.data.model.TourModel
import com.example.ulultrip.data.model.ToursResponse
import com.example.ulultrip.data.remote.ApiService

class ToursPagingSource(private val apiService: ApiService, filter: FilterModel) :
    BasePagingSource<ToursResponse, TourModel>({
        apiService.getTours(
            it,
            category = filter.category,
            region = filter.region,
            guide = filter.guide,
            date_departure = filter.date_departure,
            date_arrival = filter.date_arrival,
            complexity = filter.complexity,
            duration = filter.duration,
            price = filter.price
        )
    })

// complexity
//easy
//medium
//hard
//extra

// duration
// 1
// 3
// 7