package com.example.pokegame.ui

import com.example.pokegame.models.MoveX
import com.example.pokegame.models.VersionGroupDetail

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)