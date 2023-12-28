package com.example.supershop.ui.repository

import com.example.supershop.data.room.ItemDao
import com.example.supershop.data.room.ListDao
import com.example.supershop.data.room.StoreDao

class Repository(
    private val listDao: ListDao,
    private val storeDao: StoreDao,
    private val itemDao: ItemDao
) {
    val store = storeDao.getAllStores()
    val getItemsWithListAndStore = listDao.getItemsWithStoreAndList()

    fun getItemWithStoreAndList(id:Int) = listDao.getItemWithStoreAndListFilteredById(id)
}
