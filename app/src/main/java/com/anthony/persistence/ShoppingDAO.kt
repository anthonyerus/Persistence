package com.anthony.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShoppingDAO {

    @Insert
    fun addShoppingItem(shoppingItem: ShoppingModel)

    @Query("SELECT * from shoppingmodel")
    fun getAllshoppingItems(): List<ShoppingModel>

    @Delete
    fun delete(shoppingItem:ShoppingModel)
}