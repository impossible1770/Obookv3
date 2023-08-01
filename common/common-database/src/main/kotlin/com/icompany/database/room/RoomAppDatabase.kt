package com.icompany.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.icompany.database.room.dao.ClientDao
import com.icompany.database.room.dao.CurrentOrderDao
import com.icompany.database.room.dao.OrderDao
import com.icompany.database.room.dao.ProductDao
import com.icompany.database.room.dao.SelectedProductDao
import com.icompany.obook.data.database.room.table.*

@Database(
    entities = [CurrentOrder::class, Order::class, SelectedProduct::class, Product::class, Client::class],
    version = 5
)
abstract class RoomAppDatabase : RoomDatabase() {
    abstract fun currentOrdersDao(): CurrentOrderDao
    abstract fun clientDao(): ClientDao
    abstract fun orderDao(): OrderDao
    abstract fun productDao(): ProductDao
    abstract fun selectedProductsDao(): SelectedProductDao
}