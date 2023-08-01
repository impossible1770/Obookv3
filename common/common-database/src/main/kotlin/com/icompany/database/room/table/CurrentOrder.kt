package com.icompany.obook.data.database.room.table

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "CurrentOrder",
    foreignKeys = [ForeignKey(
        entity = Order::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("orderId"),
        onDelete = ForeignKey.CASCADE
    )
    ]
)
class CurrentOrder(
    var orderId: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}