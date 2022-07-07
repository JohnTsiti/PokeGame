package com.example.pokegame.api

import com.example.pokegame.models.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {
    @GET("/api/v2/pokemon/{id}")
    suspend fun getPokemonWithId(
        @Path("id") id:Int
    ): Response<Pokemon>
}