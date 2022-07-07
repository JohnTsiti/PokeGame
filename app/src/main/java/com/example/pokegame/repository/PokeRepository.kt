package com.example.pokegame.repository

import com.example.pokegame.api.RetrofitInstance
import com.example.pokegame.db.PokeDatabase
import com.example.pokegame.models.Pokemon

class PokeRepository(
    val db:PokeDatabase
) {
    suspend fun getPokemonWithId(id:Int) =
        RetrofitInstance.api.getPokemonWithId(id)

    suspend fun insertPokemon ( pokemon: Pokemon) =
        db.pokemonDao().insertPokemon(pokemon)

    suspend fun updatePokemon ( pokemon: Pokemon) =
        db.pokemonDao().updatePokemon(pokemon)

    fun getMyPokemon()=
        db.pokemonDao().getMyPokemon()

    fun getPokemonSeen()=
        db.pokemonDao().getPokemonSeen()
}