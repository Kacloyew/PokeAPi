package com.example.pokeapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.repository.PokemonRepository

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository()

    private val _allPokemon = MutableLiveData<List<Pokemon>>()
    val allPokemon: LiveData<List<Pokemon>> get() = _allPokemon

    private val _selectedPokemon = MutableLiveData<Pokemon?>()
    val selectedPokemon: LiveData<Pokemon?> get() = _selectedPokemon

    init {
        loadPokemon()
    }

    fun loadPokemon() {
        _allPokemon.value = repository.getAllPokemon()
    }

    fun selectPokemon(pokemon: Pokemon) {
        _selectedPokemon.value = pokemon
    }

    fun toggleFavorite(pokemonId: Int) {
        repository.toggleFavorite(pokemonId)
        // Refresca la lista
        loadPokemon()
        // Actualiza el Pokémon seleccionado si es el mismo
        _selectedPokemon.value?.let { currentPokemon ->
            if (currentPokemon.getId() == pokemonId) {
                val updatedPokemon = currentPokemon.copy(isFavorite = !currentPokemon.isFavorite)
                _selectedPokemon.value = updatedPokemon
            }
        }
    }

    fun getFavorites(): List<Pokemon> {
        return repository.getFavoritePokemon()
    }
}