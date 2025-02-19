package com.example.rickandmortyclean.repository

import com.example.rickandmortyclean.model.Character
import com.example.rickandmortyclean.network.CharacterAPI
import com.example.rickandmortyclean.network.RetroFitModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CharacterRepository(
    private val api: CharacterAPI = RetroFitModule.createAPI()
) : RepositoryContract {

    override suspend fun getCharacters(): List<Character> {
        return withContext(Dispatchers.IO) {
            return@withContext api.fetchCharacters("1").characters
        }
    }
}