package com.example.pokegame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokegame.repository.PokeRepository

class PokeViewModelProviderFactory(
    val pokeRepository: PokeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(pokeRepository) as T
    }
}