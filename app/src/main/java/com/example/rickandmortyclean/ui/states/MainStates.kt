package com.example.rickandmortyclean.ui.states

import com.example.rickandmortyclean.model.Character

sealed class MainStates {
    data object None : MainStates()
    data object Loading : MainStates()
    data class Success(val users: List<Character>) : MainStates()
    data class Error(val message: Int) : MainStates()
}