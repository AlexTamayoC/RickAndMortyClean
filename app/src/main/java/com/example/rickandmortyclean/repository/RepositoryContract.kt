package com.example.rickandmortyclean.repository

import com.example.rickandmortyclean.model.Character

interface RepositoryContract {
    suspend fun getCharacters(): List<Character>
}