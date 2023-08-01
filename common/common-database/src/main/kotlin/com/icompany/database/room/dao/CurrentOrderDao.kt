package com.icompany.database.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.icompany.database.model.ResponseCurrentOrder
import com.icompany.obook.data.database.room.table.CurrentOrder

@Dao
interface CurrentOrderDao {

    @Insert
    fun insert(currentOrder: CurrentOrder)

    @Query(
        "SELECT CurrentOrder.id as id, `Order`.id as orderId, `Order`.description as orderDescription, SUM(SelectedProducts.priceForOne * SelectedProducts.countProduct) as orderTotalPrice, `Order`.dateCreated as orderDateCreated,  Client.id as clientId, Client.imageUrl as clientImageUrl, Client.name as clientName, `Order`.priority as priority  FROM CurrentOrder INNER JOIN `Order` ON CurrentOrder.orderId = `Order`.id INNER JOIN Client ON `Order`.clientId = client.id INNER JOIN SelectedProducts ON `Order`.id = SelectedProducts.orderId GROUP BY `Order`.id ORDER BY `Order`.id DESC"
    )
    fun getAll(): List<ResponseCurrentOrder>

    @Query("DELETE FROM CurrentOrder WHERE id=:id ")
    fun deleteOrder(id: Int)
}