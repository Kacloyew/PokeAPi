package com.example.pokeapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.R
import com.example.pokeapi.adapter.PokemonAdapter
import com.example.pokeapi.model.Pokemon

class PokedexFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.rvPokemon)

        val listaPokemon = listOf(
            Pokemon("Pikachu", "https://pokeapi.co/api/v2/pokemon/25/"),
            Pokemon("Charmander", "https://pokeapi.co/api/v2/pokemon/4/"),
            Pokemon("Bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
            Pokemon("Squirtle", "https://pokeapi.co/api/v2/pokemon/7/"),
            Pokemon("Jigglypuff", "https://pokeapi.co/api/v2/pokemon/39/"),
            Pokemon("Gengar", "https://pokeapi.co/api/v2/pokemon/94/"),
            Pokemon("Mewtwo", "https://pokeapi.co/api/v2/pokemon/150/"),
            Pokemon("Eevee", "https://pokeapi.co/api/v2/pokemon/133/")
        )

        val adapter = PokemonAdapter(listaPokemon)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}