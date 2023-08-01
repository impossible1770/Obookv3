package com.icompany.database.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.icompany.obook.data.database.room.table.Client

@Dao
interface ClientDao {

    @Query("SELECT * FROM client ORDER BY id DESC")
    fun getAll(): List<Client>

    @Query("SELECT * FROM client WHERE id=:id")
    fun getById(id: Int): Client

    @Insert
    fun insert(client: Client)

    @Update
    fun update(client: Client)

    @Delete
    fun delete(client: Client)

}