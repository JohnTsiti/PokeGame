package com.example.pokegame.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokegame.adapters.PokemonAdapter
import com.example.pokegame.databinding.FragmentMyPokemonBinding
import com.example.pokegame.ui.PokeGameActivity
import com.example.pokegame.ui.PokemonViewModel


class MyPokemonFragment : Fragment() {

    lateinit var binding: FragmentMyPokemonBinding
    lateinit var viewModel: PokemonViewModel
    lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyPokemonBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as PokeGameActivity).viewModel

        setupRecyclerView()

        viewModel.getMyPokemon().observe(viewLifecycleOwner, Observer { pokemon->
            pokemonAdapter.differ.submitList(pokemon)
        })
    }



    private fun setupRecyclerView(){
        pokemonAdapter = PokemonAdapter()
        binding.rvPokemon.apply {
            adapter=pokemonAdapter
            layoutManager=GridLayoutManager(activity,2)
            //layoutManager=LinearLayoutManager(activity)
        }
    }



}