package com.example.task3weekly8.data.db

import androidx.room.Room
import com.example.task3weekly8.MainApp

object DataBaseFactory {
    private val dataBase: DataBase by lazy {
        Room.databaseBuilder(
            MainApp.ContextHolder.context,
            DataBase::class.java, "favorite.db")
            .build()
    }

    fun create(): DataBase = dataBase
}