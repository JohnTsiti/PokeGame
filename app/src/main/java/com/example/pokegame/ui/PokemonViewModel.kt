package com.example.pokegame.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokegame.models.Pokemon
import com.example.pokegame.repository.PokeRepository
import com.example.pokegame.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class PokemonViewModel(
    val pokeRepository: PokeRepository
) : ViewModel() {

    val pokemon: MutableLiveData<Resource<Pokemon>> = MutableLiveData()

    fun getPokemonWithId(id: Int) = viewModelScope.launch {
        pokemon.postValue(Resource.Loading())
        val response = pokeRepository.getPokemonWithId(id)
        pokemon.postValue(handlePokemonResponse(response))

    }

    private fun handlePokemonResponse(response: Response<Pokemon>): Resource<Pokemon> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun insertPokemon(pokemon: Pokemon)=
        viewModelScope.launch {
            pokeRepository.insertPokemon(pokemon)
        }

    fun updatePokemon(pokemon: Pokemon)=
        viewModelScope.launch {
            pokeRepository.updatePokemon(pokemon)
        }

    fun getMyPokemon() = pokeRepository.getMyPokemon()

    fun getPokemonSeen() = pokeRepository.getPokemonSeen()
}