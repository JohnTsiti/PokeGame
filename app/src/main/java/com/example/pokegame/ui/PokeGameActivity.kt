package com.example.pokegame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.pokegame.R
import com.example.pokegame.databinding.ActivityPokeGameBinding
import com.example.pokegame.db.PokeDatabase
import com.example.pokegame.repository.PokeRepository

class PokeGameActivity : AppCompatActivity() {
    lateinit var binding: ActivityPokeGameBinding
    lateinit var viewModel: PokemonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokeGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.bottomNavigationView.setupWithNavController(binding.navHostFragment.findNavController())

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        val repository = PokeRepository(PokeDatabase.getInstance(this))
        val viewModelProviderFactory = PokeViewModelProviderFactory(repository)
        viewModel =
            ViewModelProvider(this, viewModelProviderFactory)[PokemonViewModel::class.java]

    }
}