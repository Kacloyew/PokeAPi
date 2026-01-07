package com.example.pokeapi.repository

import com.example.pokeapi.model.Pokemon

class PokemonRepository {
    private val pokemonList = mutableListOf<Pokemon>()

    init {
        pokemonList.addAll(
            listOf(
                // Cambia esto: usa solo name y url, el id se calcula solo
                Pokemon("Pikachu", "https://pokeapi.co/api/v2/pokemon/25/"),
                Pokemon("Charizard", "https://pokeapi.co/api/v2/pokemon/6/"),
                Pokemon("Bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                Pokemon("Squirtle", "https://pokeapi.co/api/v2/pokemon/7/"),
                Pokemon("Jigglypuff", "https://pokeapi.co/api/v2/pokemon/39/"),
                Pokemon("Gengar", "https://pokeapi.co/api/v2/pokemon/94/"),
                Pokemon("Mewtwo", "https://pokeapi.co/api/v2/pokemon/150/"),
                Pokemon("Eevee", "https://pokeapi.co/api/v2/pokemon/133/")
            )
        )
    }

    fun getAllPokemon(): List<Pokemon> = pokemonList

    fun getFavoritePokemon(): List<Pokemon> = pokemonList.filter { it.isFavorite }

    fun toggleFavorite(pokemonId: Int) {
        // Busca el Pokémon por el ID que calculamos de la URL
        val pokemon = pokemonList.find {
            it.url.split("/").last { part -> part.isNotEmpty() }.toIntOrNull() == pokemonId
        }
        pokemon?.isFavorite = !(pokemon?.isFavorite ?: false)
    }

    fun searchPokemon(query: String): List<Pokemon> {
        return pokemonList.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun searchFavoritePokemon(query: String): List<Pokemon> {
        return pokemonList.filter {
            it.isFavorite && it.name.contains(query, ignoreCase = true)
        }
    }

    fun removePokemon(pokemon: Pokemon) {
        pokemonList.remove(pokemon)
    }

    fun getPokemonById(id: Int): Pokemon? {
        return pokemonList.find {
            it.url.split("/").last { part -> part.isNotEmpty() }.toIntOrNull() == id
        }
    }
}