package com.example.ulultrip.core.network.paging

interface DataMapper<T> {
    fun responseToModel(): List<T>
}