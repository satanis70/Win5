package com.example.win5

import com.example.win5.model.PopularLeagueModel
import com.example.win5.model.PopularTeam
import com.example.win5.model.PopularTeamsModel
import com.example.win5.model.RichPlayersModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/win5/popular_teams.json")
    fun getPopularTeams(): Call<PopularTeamsModel>
    @GET("/win5/popular_league.json")
    fun getPopularLeague(): Call<PopularLeagueModel>
    @GET("/win5/richest_players.json")
    fun getPlayers(): Call<RichPlayersModel>
}