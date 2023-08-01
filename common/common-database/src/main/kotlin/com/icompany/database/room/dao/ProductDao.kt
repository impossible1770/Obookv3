package com.icompany.database.room.dao

import androidx.room.*
import com.icompany.obook.data.database.room.table.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM product ORDER BY id DESC")
    fun getAll(): List<Product>

    @Query("SELECT * FROM product WHERE id=:id")
    fun getById(id: Int): Product

    @Insert
    fun insert(product: Product)

    @Update
    fun update(product: Product)

    @Delete
    fun delete(product: Product)
}