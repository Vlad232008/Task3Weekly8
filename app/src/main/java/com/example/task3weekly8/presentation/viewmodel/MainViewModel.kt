package com.example.task3weekly8.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task3weekly8.data.db.DataBaseFactory
import com.example.task3weekly8.data.db.repository.Repository
import com.example.task3weekly8.data.db.repository.RepositoryImpl
import com.example.task3weekly8.data.dto.ImageResponce
import com.example.task3weekly8.data.dto.MessageResponce
import com.example.task3weekly8.data.dto.VoteRequest
import com.example.task3weekly8.data.ktor.CatService
import com.example.task3weekly8.presentation.utils.AppState
import com.example.task3weekly8.presentation.utils.mapImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val repository: Repository = RepositoryImpl()
) : ViewModel() {

    private val service = CatService.create()
    private val dataBase = DataBaseFactory.create().favoriteDao()
    private val dataImage = MutableLiveData<AppState>()
    private val dataVote = MutableLiveData<MessageResponce>()

    val liveDataPost: LiveData<AppState> = dataImage
    val liveDataVote: LiveData<MessageResponce> = dataVote

    fun getData() {
        viewModelScope.launch { loadData() }
    }

    private suspend fun loadData() = withContext(Dispatchers.IO) {
        try {
            dataImage.postValue(AppState.SuccessMain(service.getRandomImage()))
        } catch (e: Throwable) {
            dataImage.postValue(AppState.Error(e))
        }
    }

    fun saveFavorite(imageResponse: ImageResponce) {
        viewModelScope.launch(Dispatchers.IO) {
            dataBase.insert(mapImage(imageResponse))
        }
    }

    fun postVote(postRequest: VoteRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            dataVote.postValue(service.createVote(postRequest))
        }
    }
}