package com.example.ulultrip.data.remote

import com.example.ulultrip.data.model.CM
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("tour/src/v1/categories")
    suspend fun getTourCategories(
        @Query("limit") limit : Int = 1,
        @Query("offset") offset : Int = 0
    ) : Response<CM>
}