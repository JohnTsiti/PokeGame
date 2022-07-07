package com.example.pokegame.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pokegame.models.Pokemon

@Dao
interface PokeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPokemon(pokemon: Pokemon):Long

    @Update
    suspend fun updatePokemon(pokemon: Pokemon)


    @Query("SELECT * FROM pokemon")
    fun getPokemonSeen(): LiveData<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE captured=true")
    fun getMyPokemon(): LiveData<List<Pokemon>>

    @Delete
    suspend fun deletePokemon(pokemon: Pokemon)
}