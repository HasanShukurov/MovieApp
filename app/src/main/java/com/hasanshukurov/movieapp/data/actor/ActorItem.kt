package com.hasanshukurov.movieapp.data.actor

data class ActorItem(
    val _links: Links,
    val birthday: String,
    val country: Country,
    val deathday: String,
    val gender: String,
    val id: Int,
    val image: Image,
    val name: String,
    val updated: Int,
    val url: String
)