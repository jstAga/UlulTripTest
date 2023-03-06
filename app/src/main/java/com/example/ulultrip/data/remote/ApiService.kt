package com.example.ulultrip.data.remote

import com.example.ulultrip.data.model.CategoryResponse
import com.example.ulultrip.data.model.TourModel
import com.example.ulultrip.data.model.ToursResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("tour/src/v1/categories")
    suspend fun getTourCategories(
        @Query("offset") offset : Int = 0,
        @Query("limit") limit : Int = 1,
    ) : Response<CategoryResponse>

    @GET("/tour/src/v1/tours")
    suspend fun getTours(
        @Query("offset") offset : Int = 0,
        @Query("limit") limit : Int = 5,
        @Query("category") category : String = "",
        @Query("region") region : String = "",
        @Query("guide") guide : String = "",
        @Query("date_departure") date_departure : String = "",
        @Query("date_arrival") date_arrival : String = "",
        @Query("complexity") complexity : String = "",
        @Query("duration") duration : String = "",
        @Query("price") price : String = "",
    ) : Response<ToursResponse>
}