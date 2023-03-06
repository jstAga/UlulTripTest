package com.example.ulultrip.data.model

data class FilterModel(
    var category: String = "",
    var region: String = "",
    var guide: String = "",
    var date_departure: String = "",
    var date_arrival: String = "",
    var complexity: String = "",
    var duration: String = "",
    var price: String = "",
)