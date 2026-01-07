package com.example.pokeapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pokeapi.R

class DetallesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_detalles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val pokemonName = arguments?.getString("pokemonName") ?: "Sin nombre"
        val pokemonId = arguments?.getInt("pokemonId") ?: 0


        val textPokemonName: TextView = view.findViewById(R.id.textPokemonName)
        val textPokemonId: TextView = view.findViewById(R.id.textPokemonId)
        val textPokemonFavorite: TextView = view.findViewById(R.id.textPokemonFavorite)
        val textPokemonDescription: TextView = view.findViewById(R.id.textPokemonDescription)
        val buttonBack: Button = view.findViewById(R.id.buttonBack)
        val buttonToggleFavorite: Button = view.findViewById(R.id.buttonToggleFavorite)


        textPokemonName.text = pokemonName
        textPokemonId.text = "ID: $pokemonId"
        textPokemonFavorite.text = "No favorito"
        textPokemonDescription.text = "Este es un Pokémon de la Pokédex. Haz click en la estrella para marcarlo como favorito."


        buttonBack.setOnClickListener {

            requireActivity().supportFragmentManager.popBackStack()
        }


        buttonToggleFavorite.setOnClickListener {

            val esFavorito = textPokemonFavorite.text.toString().contains("FAVORITO")

            if (esFavorito) {

                textPokemonFavorite.text = "No favorito"
                buttonToggleFavorite.text = "⭐ Marcar Favorito"
            } else {

                textPokemonFavorite.text = "⭐ FAVORITO"
                buttonToggleFavorite.text = "✖ Quitar Favorito"
            }
        }
    }
}