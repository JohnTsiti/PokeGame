package com.example.pokegame.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.pokegame.databinding.FragmentRandomEncounterBinding
import com.example.pokegame.models.Pokemon
import com.example.pokegame.ui.PokeGameActivity
import com.example.pokegame.ui.PokemonViewModel
import com.example.pokegame.util.Constants
import com.example.pokegame.util.Resource


class RandomEncounterFragment : Fragment() {
    lateinit var binding: FragmentRandomEncounterBinding
    lateinit var viewModel: PokemonViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRandomEncounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as PokeGameActivity).viewModel






        viewModel.pokemon.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { pokemon ->

                        updatePokemonData(pokemon)
                        viewModel.insertPokemon(pokemon)
                        binding.btnPokeball.visibility = View.VISIBLE

                        binding.btnPokeball.setOnClickListener {
                            pokemon.captured = true
                            viewModel.updatePokemon(pokemon)
                            Toast.makeText(
                                activity,
                                "${pokemon.name} is captured, check your Backpack!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Log.e(Constants.TAG, "An error occurred: $message")
                    }
                }
                is Resource.Loading -> {

                }
            }

        })

        binding.btnWalk.setOnClickListener {
            var randomEncounter = (1..151).shuffled().first()
            viewModel.getPokemonWithId(randomEncounter)
        }


    }

    private fun updatePokemonData(pokemon: Pokemon) {
        binding.apply {
            Glide.with(this.root).load(pokemon.sprites?.front_default).into(ivMain)
            tvHeight.text = (pokemon.height.toDouble() / 10.0).toString() + " m"
            tvWeight.text = (pokemon.weight.toDouble() / 10.0).toString() + " kg"
            tvName.text = pokemon.name
        }
    }
}