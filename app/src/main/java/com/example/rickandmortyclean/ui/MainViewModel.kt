package com.example.rickandmortyclean.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyclean.model.CharacterResponse
import com.example.rickandmortyclean.network.CharacterAPI
import com.example.rickandmortyclean.network.RetroFitModule
import com.example.rickandmortyclean.repository.CharacterRepository
import com.example.rickandmortyclean.repository.RepositoryContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.rickandmortyclean.ui.states.MainStates
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val randomUserRepo: CharacterRepository = CharacterRepository()

    private val _state = MutableLiveData<MainStates>(MainStates.None)
    val state: LiveData<MainStates> = _state

    fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.postValue(MainStates.Loading)
            delay(100)
            try {
                val users = randomUserRepo.getCharacters()
                _state.postValue(MainStates.Success(listOf()))
                _state.postValue(MainStates.Success(users))
            } catch (e: Throwable) {
                Log.e("Fetch", e.toString())
                _state.postValue(MainStates.Error(1))
            }
        }
    }
}