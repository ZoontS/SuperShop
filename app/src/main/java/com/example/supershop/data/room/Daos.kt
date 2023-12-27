package com.example.supershop.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.supershop.data.room.models.Item
import com.example.supershop.data.room.models.ShoppingList
import com.example.supershop.data.room.models.Store
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: Item)

    @Delete()
    suspend fun delete(item: Item)

    @Query("SELECT * FROM item")
    fun getAllItems(): Flow<List<Item>>

    @Query("SELECT * FROM item WHERE item_id = :itemId")
    fun getItem(itemId: Int): Flow<Item>
}

@Dao
interface StoreDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(store: Store)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(store: Store)

    @Delete()
    suspend fun delete(store: Store)

    @Query("SELECT * FROM store")
    fun getAllStores(): Flow<List<Store>>

    @Query("SELECT * FROM store WHERE store_id = :storeId")
    fun getStore(storeId: Int): Flow<Store>
}

@Dao
interface ShoppingListDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(shoppingList: ShoppingList)

    @Query("""
        SELECT * FROM item AS I INNER JOIN
        
    """)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(shoppingList: ShoppingList)

    @Delete()
    suspend fun delete(shoppingList: ShoppingList)

    @Query("SELECT * FROM shopping_list")
    fun getAllShoppingLists(): Flow<List<ShoppingList>>

    @Query("SELECT * FROM shopping_list WHERE list_id = :listId")
    fun getShoppingList(listId: Int): Flow<ShoppingList>
}