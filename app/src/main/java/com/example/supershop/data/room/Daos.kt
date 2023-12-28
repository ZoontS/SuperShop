package com.example.supershop.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
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
interface ListDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(shoppingList: ShoppingList)

    @Query(
        """
        SELECT * FROM item AS I INNER JOIN shopping_list AS S
        ON I.listId = S.list_id INNER JOIN store AS ST
        ON I.storeIdFk = ST.store_id
    """
    )
    fun getItemsWithStoreAndList():Flow<List<ItemsWithStoreAndList>>

    @Query(
        """
        SELECT * FROM item AS I INNER JOIN shopping_list AS S
        ON I.listId = S.list_id INNER JOIN store AS ST
        ON I.storeIdFk = ST.store_id WHERE S.list_id =:listId
    """
    )
    fun getItemsWithStoreAndListFilteredById(listId:Int)
    :Flow<List<ItemsWithStoreAndList>>

    @Query(
        """
        SELECT * FROM item AS I INNER JOIN shopping_list AS S
        ON I.listId = S.list_id INNER JOIN store AS ST
        ON I.storeIdFk = ST.store_id WHERE I.item_id =:itemId
    """
    )
    fun getItemWithStoreAndListFilteredById(itemId:Int)
            :Flow<ItemsWithStoreAndList>
}

data class ItemsWithStoreAndList(
    @Embedded val item: Item,
    @Embedded val shoppingList: ShoppingList,
    @Embedded val store: Store
)