package com.example.pokeapi.model

data class Pokemon(
    val name: String,
    val url: String,
    var isFavorite: Boolean = false
) {
    // Añade esta función para obtener el ID
    fun getId(): Int {
        val parts = url.split("/").filter { it.isNotEmpty() }
        return parts.last().toIntOrNull() ?: 0
    }
}