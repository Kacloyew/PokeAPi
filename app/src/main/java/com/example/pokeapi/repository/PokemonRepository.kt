package com.example.pokeapi.repository

import com.example.pokeapi.model.Pokemon

class PokemonRepository {

    private val pokemonList = mutableListOf<Pokemon>()

    init {
        pokemonList.apply {
            add(Pokemon(1, "Pikachu", "Ratón eléctrico amarillo", "Eléctrico"))
            add(Pokemon(2, "Charizard", "Dragón de fuego volador", "Fuego/Volador"))
            add(Pokemon(3, "Bulbasaur", "Semilla dinosaurio", "Planta/Veneno"))
            add(Pokemon(4, "Squirtle", "Tortuga acuática", "Agua"))
            add(Pokemon(5, "Jigglypuff", "Globo cantante", "Normal/Hada"))
        }
    }

    fun getAllPokemon(): List<Pokemon> = pokemonList

    fun removePokemon(pokemon: Pokemon) {
        pokemonList.remove(pokemon)
    }

    fun getPokemonById(id: Int): Pokemon? {
        return pokemonList.find { it.id == id}
    }
}