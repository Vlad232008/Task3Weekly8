package com.example.task3weekly8.presentation.utils

import com.example.task3weekly8.data.db.entity.FavoriteItem
import com.example.task3weekly8.data.dto.ImageResponce
import com.example.task3weekly8.data.model.Cat

fun mapImage(imageResponse: ImageResponce): FavoriteItem {
    return FavoriteItem(
        imageResponse.id,
        imageResponse.url,
    )
}

fun mapFavorite(favoriteItemList: List<FavoriteItem>): List<Cat> {
    return favoriteItemList.map {
        Cat(it.id, it.image)
    }
}