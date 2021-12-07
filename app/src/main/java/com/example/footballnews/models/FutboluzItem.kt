package com.example.footballnews.models

data class FutboluzItem(
    val goals: String,
    val id: Int,
    val logoTeamA: String,
    val logoTeamH: String,
    val teamA: String,
    val teamH: String,
    val time: String,
    val tournamentName: String
)