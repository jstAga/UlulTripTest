package com.example.ulultrip.data.model

import com.example.ulultrip.core.network.paging.DataMapper

data class ToursResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<TourModel>,
) : DataMapper<TourModel> {
    override fun responseToModel(): List<TourModel> = this.results
}

data class TourModel(
    val average_rating: String,
    val category: CategoryModel,
    val complexity: String,
    val date_arrival: String,
    val date_departure: String,
    val date_published: String,
    val description: String,
    val duration: String,
    val guide: Guide,
    val id: Int,
    val is_hot: Boolean,
    val price: Int,
    val quantity_limit: Int,
    val region: Region,
    val set_actual_limit: Int,
    val slug: String,
    val title: String,
    val tour_images: List<Any>,
)

data class Region(
    val id: Int,
    val name: String,
)

data class Guide(
    val get_initials: String,
    val id: Int,
    val photo: Any,
)