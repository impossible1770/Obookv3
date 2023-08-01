package com.icompany.obook.data.database.room.table

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Order",
    foreignKeys = [ForeignKey(
        entity = Client::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("clientId"),
        onDelete = ForeignKey.CASCADE
    )
    ]
)
class Order(
    var clientId: Int,
    var description: String,
    var dateCreated: Long
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var priority: Int = 0
}

