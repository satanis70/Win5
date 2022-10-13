package com.example.win5.model


import com.google.gson.annotations.SerializedName

data class RichPlayersModel(
    @SerializedName("richest_players")
    val richestPlayers: ArrayList<RichestPlayer>
)