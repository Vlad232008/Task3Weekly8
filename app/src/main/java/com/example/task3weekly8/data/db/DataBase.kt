package com.example.task3weekly8.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.task3weekly8.data.db.entity.FavoriteItem
import com.example.task3weekly8.data.db.Dao

@Database(entities = [FavoriteItem::class],
    version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun favoriteDao(): Dao
}