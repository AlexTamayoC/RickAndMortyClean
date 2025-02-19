package com.example.rickandmortyclean.network

import com.example.rickandmortyclean.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterAPI {
    @GET("character")
    suspend fun fetchCharacters(
        @Query("id") id: String
    ): CharacterResponse
}


