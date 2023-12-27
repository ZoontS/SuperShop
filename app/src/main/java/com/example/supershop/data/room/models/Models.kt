package com.example.supershop.data.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "shopping_list")
data class ShoppingList(
    @ColumnInfo(name = "list_id")
    @PrimaryKey
    val id: Int,
    val name: String
)

@Entity(tableName = "item")
data class Item(
    @ColumnInfo(name = "item_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val itemName: String,
    val quantity: Int,
    val listIdFk: Int,
    val storeIdFk: Int,
    val date: Date,
    val isChecked: Boolean,
)

@Entity(tableName = "store")
data class Store(
    @ColumnInfo(name = "store_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val listIdFk: Int,
    val storeName: String,
    val address: String,
    val city: String,
    val state: String,
)