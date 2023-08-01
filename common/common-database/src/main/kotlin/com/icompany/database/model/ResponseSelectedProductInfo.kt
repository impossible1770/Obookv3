package com.icompany.database.model

import java.io.Serializable

data class ResponseSelectedProductInfo(
    var id: Int,
    var productId: Int,
    var productCaption: String,
    var productImageUrl: String,
    var productCount: Double,
    var productPrice: Double
): Serializable{

    fun getFullPrice() = productPrice * productCount
}