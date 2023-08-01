package com.icompany.database.room.dao

import androidx.room.*
import com.icompany.database.model.ResponseOrderInfo
import com.icompany.obook.data.database.room.table.Order

@Dao
interface OrderDao {

    @Query("SELECT * FROM `order` ORDER BY id DESC")
    fun getAll(): List<Order>

    @Query("SELECT * FROM `order` WHERE id=:id")
    fun getById(id: Int): Order

    @Query(
        "SELECT `Order`.id as id, `Order`.description as orderDescription, `Order`.dateCreated as dateCreated, SUM(SelectedProducts.priceForOne * SelectedProducts.countProduct) as orderTotalPrice,  Client.id as clientId, Client.imageUrl as clientImageUrl, Client.name as clientName  FROM `Order` INNER JOIN Client ON `Order`.clientId = client.id INNER JOIN SelectedProducts ON `Order`.id = SelectedProducts.orderId  WHERE `Order`.id=:id GROUP BY `Order`.id"
    )
    fun getInfoOrderById(id: Int): ResponseOrderInfo

    @Query(
        "SELECT `Order`.id as id, `Order`.description as orderDescription, `Order`.dateCreated as dateCreated, SUM(SelectedProducts.priceForOne * SelectedProducts.countProduct) as orderTotalPrice,  Client.id as clientId, Client.imageUrl as clientImageUrl, Client.name as clientName  FROM `Order` INNER JOIN Client ON `Order`.clientId = client.id INNER JOIN SelectedProducts ON `Order`.id = SelectedProducts.orderId LEFT JOIN CurrentOrder ON CurrentOrder.orderId = `Order`.id \n" +
                "WHERE CurrentOrder.id IS NULL GROUP BY `Order`.id ORDER BY `Order`.id DESC"
    )
    fun getAllHistoryOrders(): List<ResponseOrderInfo>

    @Insert
    fun insert(order: Order): Long

    @Update
    fun update(order: Order)

    @Update
    fun update(order: List<Order>)

    @Delete
    fun delete(order: Order)

    @Query("DELETE FROM `Order` WHERE id=:id ")
    fun deleteById(id: Int)


}