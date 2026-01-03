package com.example.pokeapi.model

data class Pokemon(

    val id: Int,
    val name: String,
    val description: String,
    val type: String = "",
    val imageUrl: String = ""
)