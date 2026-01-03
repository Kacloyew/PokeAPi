package com.example.pokeapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.repository.PokemonRepository

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository()

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> get() = _pokemonList

    private val _selectedPokemon = MutableLiveData<Pokemon>()
    val selectedPokemon: LiveData<Pokemon> get() = _selectedPokemon

    init {
        loadPokemon()
    }

    fun loadPokemon() {
        _pokemonList.value = repository.getAllPokemon()
    }

    fun removePokemon(pokemon: Pokemon) {
        repository.removePokemon(pokemon)
        loadPokemon()
    }

    fun selectPokemon(pokemon: Pokemon) {
        _selectedPokemon.value = pokemon
    }
}