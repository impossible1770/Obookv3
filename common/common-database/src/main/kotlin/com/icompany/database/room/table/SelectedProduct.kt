package com.icompany.obook.data.database.room.table

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "SelectedProducts",
    foreignKeys = [ForeignKey(
        entity = Order::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("orderId"),
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = Product::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("productId"),
        onDelete = ForeignKey.CASCADE
    )
    ]
)
class SelectedProduct(
    var orderId: Int,
    var productId: Int,
    var priceForOne: Double,
    var countProduct: Double
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}