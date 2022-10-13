package com.example.win5.model


import com.google.gson.annotations.SerializedName

data class PopularTeamsModel(
    @SerializedName("popular_teams")
    val popularTeams: ArrayList<PopularTeam>
)