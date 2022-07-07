package com.example.pokegame.ui

import com.example.pokegame.models.DiamondPearl
import com.example.pokegame.models.HeartgoldSoulsilver
import com.example.pokegame.models.Platinum

data class GenerationIv(
    val `diamond-pearl`: DiamondPearl,
    val `heartgold-soulsilver`: HeartgoldSoulsilver,
    val platinum: Platinum
)