package com.example.pokegame.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokegame.databinding.ItemPokemonBinding
import com.example.pokegame.models.Pokemon

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PokemonViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
       val pokemon = differ.currentList[position]
        holder.binding.apply {
            Glide.with(this.root).load(pokemon.sprites?.front_default).into(ivMain)
            tvHeight.text = (pokemon.height.toDouble() / 10.0).toString() + " m"
            tvWeight.text = (pokemon.weight.toDouble() / 10.0).toString() + " kg"
            tvName.text = "No.: ${pokemon.id} ${pokemon.name}"

        }
    }



}