package com.example.pokegame.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.pokegame.ui.*

@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    @Ignore
    var abilities: List<Ability>,
    var base_experience: Int,
    @Ignore
    var forms: List<Form>,
    @Ignore
    var game_indices: List<GameIndice>,
    var height: Int,
    @Ignore
    var held_items: List<Any>,
    @Ignore
    var is_default: Boolean,
    @Ignore
    var location_area_encounters: String,
    @Ignore
    var moves: List<Move>,
    var name: String,
    var order: Int,
    @Ignore
    var past_types: List<Any>,
    @Ignore
    var species: Species?,
    var sprites: Sprites?,
    @Ignore
    var stats: List<Stat>,
    @Ignore
    var types: List<Type>,
    var weight: Int,
    var captured:Boolean
){
    constructor() : this(0, listOf(),0, listOf(), listOf(),0, listOf(),false,"", listOf(),"",0,
        listOf(),
      null, null, listOf(), listOf(),0,false)
}