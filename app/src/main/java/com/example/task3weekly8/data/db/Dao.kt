package com.example.task3weekly8.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.task3weekly8.data.db.entity.FavoriteItem

@Dao
interface Dao {

    @Query("select * from favorite_table")
    suspend fun getFavoriteList(): List<FavoriteItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: FavoriteItem)
}