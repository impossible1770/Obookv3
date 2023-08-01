package com.icompany.database.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
@Serializable
data class ResponseCurrentOrder(
    var id: Int,
    var orderId: Int,
    var orderDescription: String,
    var orderTotalPrice: Double,
    var orderDateCreated: Long,
    var clientId: Int,
    var clientImageUrl: String,
    var clientName: String,
    var priority: Int
)
