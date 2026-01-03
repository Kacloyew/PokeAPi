package com.example.pokeapi.repository

import com.example.pokeapi.model.Pokemon

class PokemonRepository {
    private val pokemonList = mutableListOf<Pokemon>()

    init {
        // Datos de ejemplo
        pokemonList.addAll(
            listOf(
                Pokemon(1, "Pikachu", "Ratón eléctrico amarillo"),
                Pokemon(2, "Charizard", "Dragón de fuego volador"),
                Pokemon(3, "Bulbasaur", "Semilla dinosaurio"),
                Pokemon(4, "Squirtle", "Tortuga acuática"),
                Pokemon(5, "Jigglypuff", "Globo cantante")
            )
        )
    }

    fun getAllPokemon(): List<Pokemon> = pokemonList

    fun removePokemon(pokemon: Pokemon) {
        pokemonList.remove(pokemon)
    }
}