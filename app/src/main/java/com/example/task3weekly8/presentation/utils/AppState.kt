package com.example.task3weekly8.presentation.utils

import com.example.task3weekly8.data.model.Cat
import com.example.task3weekly8.data.dto.ImageResponce

sealed class AppState {
    data class SuccessMain(val imageResponse: List<ImageResponce>) : AppState()
    data class SuccessFavorite(val favoriteData: List<Cat>) : AppState()
    data class Error(val e: Throwable) : AppState()
}