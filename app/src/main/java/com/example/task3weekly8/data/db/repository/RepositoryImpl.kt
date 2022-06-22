package com.example.task3weekly8.data.db.repository

import com.example.task3weekly8.data.db.DataBaseFactory
import com.example.task3weekly8.data.dto.ImageResponce
import com.example.task3weekly8.data.model.Cat
import com.example.task3weekly8.presentation.utils.mapFavorite
import com.example.task3weekly8.presentation.utils.mapImage

class RepositoryImpl : Repository {

    private val db = DataBaseFactory.create().favoriteDao()

    override suspend fun getDataFromDB(): List<Cat> {
        return mapFavorite(db.getFavoriteList())
    }

    override suspend fun insertDataToDB(imageResponse: ImageResponce) {
        db.insert(mapImage(imageResponse))
    }
}