package com.example.rickandmortyclean.network

import com.example.rickandmortyclean.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterAPI {
    @GET("api/")
    suspend fun fetchUsers(
        @Query("characters") userSize: Int = 50
    ): CharacterResponse
}