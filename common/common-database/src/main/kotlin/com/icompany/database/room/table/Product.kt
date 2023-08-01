package com.icompany.obook.data.database.room.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class Product(
    var imageUrl: String,
    var caption: String,
    var pricePerUnit: Double
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}