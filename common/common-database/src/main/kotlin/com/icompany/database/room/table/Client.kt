package com.icompany.obook.data.database.room.table

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Client")
data class Client(
        var imageUrl: String,
        var name: String,
        var phone: String,
        var address: String,
        var birthday: Long
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    companion object{
        fun getInstance() = Client("", "", "", "", 0)
    }
}