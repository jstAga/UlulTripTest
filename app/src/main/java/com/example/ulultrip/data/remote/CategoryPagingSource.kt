package com.example.ulultrip.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.ulultrip.data.model.ResultModel

class CategoryPagingSource(private val apiService: ApiService) : PagingSource<Int, ResultModel>() {
    override fun getRefreshKey(state: PagingState<Int, ResultModel>): Int? {
        return null
    }

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, ResultModel> {
        return try {
            val currentItem = params.key ?: 0
            val response = apiService.getTourCategories(offset = currentItem)
            val responseData = mutableListOf<ResultModel>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

            PagingSource.LoadResult.Page(
                data = responseData,
                prevKey = if (currentItem == 0) null else -1,
                nextKey = currentItem.plus(1)
            )
        } catch (e: Exception) {
            PagingSource.LoadResult.Error(e)
        }
    }
}