package com.example.ulultrip.data.model

import com.example.ulultrip.core.network.paging.DataMapper

data class CategoryResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<CategoryModel>
) : DataMapper<CategoryModel> {
    override fun responseToModel(): List<CategoryModel> = this.results
}

data class CategoryModel(
    val id: Int,
    val name: String
)