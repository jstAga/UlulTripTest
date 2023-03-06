package com.example.ulultrip.core.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.Response

abstract class BasePagingSource<ResponseModel : DataMapper<ResultModel>, ResultModel : Any> (
    private val request: suspend (pos: Int) -> Response<ResponseModel>
) :
    PagingSource<Int, ResultModel>() {

    override fun getRefreshKey(state: PagingState<Int, ResultModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultModel> {
        return try {
            val currentItem = params.key ?: 0
            val response = request(currentItem)
            val responseData = mutableListOf<ResultModel>()
            val data = response.body()?.responseToModel() ?: emptyList()

            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentItem == 0) null else -1,
                nextKey = currentItem.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}