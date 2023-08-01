package com.icompany.database.model

data class ResponseOrderInfo(
        var id: Int,
        var orderDescription: String,
        var orderTotalPrice: Double,
        var clientId: Int,
        var clientImageUrl: String,
        var clientName: String,
        var dateCreated: Long
)
