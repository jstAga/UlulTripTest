package com.example.ulultrip.data.model

data class CM(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<ResultModel>
)

data class ResultModel(
    val id: Int,
    val name: String
)

