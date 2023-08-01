package com.icompany.database.room.dao

import androidx.room.*
import com.icompany.database.model.ResponseSelectedProductInfo
import com.icompany.obook.data.database.room.table.SelectedProduct

@Dao
interface SelectedProductDao {

    @Query("SELECT * FROM selectedproducts ORDER BY id DESC")
    fun getAll(): List<SelectedProduct>

    @Query("SELECT * FROM selectedproducts WHERE orderId=:id ORDER BY id DESC ")
    fun getAllByOrderId(id: Int): List<SelectedProduct>

    @Query("SELECT selectedproducts.id as id, Product.id as productId, Product.caption as productCaption, Product.imageUrl as productImageUrl, selectedproducts.countProduct as productCount, selectedproducts.priceForOne as productPrice  FROM selectedproducts INNER JOIN Product ON selectedproducts.productId = Product.id WHERE selectedproducts.orderId = :id")
    fun getAllProductInfoByOrderId(id: Int): List<ResponseSelectedProductInfo>

    @Query("SELECT * FROM selectedproducts WHERE id=:id")
    fun getById(id: Int): SelectedProduct

    @Insert
    fun insert(selectedProduct: SelectedProduct)

    @Insert
    fun insertAll(data: List<SelectedProduct>)

    @Update
    fun update(selectedProduct: SelectedProduct)

    @Delete
    fun delete(selectedProduct: SelectedProduct)

    @Query("DELETE FROM SelectedProducts WHERE orderId=:id ")
    fun deleteByIdOrder(id: Int)

}