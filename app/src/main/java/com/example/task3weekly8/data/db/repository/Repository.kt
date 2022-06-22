package com.example.task3weekly8.data.db.repository

import com.example.task3weekly8.data.dto.ImageResponce
import com.example.task3weekly8.data.model.Cat

interface Repository {
    suspend fun getDataFromDB(): List<Cat>
    suspend fun insertDataToDB(imageResponse: ImageResponce)
}