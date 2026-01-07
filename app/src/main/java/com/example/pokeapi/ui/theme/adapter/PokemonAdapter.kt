package com.example.pokeapi.adapter


import com.bumptech.glide.Glide
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.R
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.ui.DetallesFragment

class PokemonAdapter(private val pokemonList: List<Pokemon>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPokemonImage: ImageView = itemView.findViewById(R.id.ivPokemonImage)
        val tvPokemonName: TextView = itemView.findViewById(R.id.tvPokemonName)
        val ivFavorite: ImageView = itemView.findViewById(R.id.ivFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]

        // 1. PONER NOMBRE
        holder.tvPokemonName.text = pokemon.name

        // 2. CARGAR IMAGEN CON GLIDE
        val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemon.getId()}.png"

        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.ic_pokeball) // imagen mientras carga
            .error(R.drawable.ic_pokeball) // imagen si hay error
            .into(holder.ivPokemonImage)

        // 3. ESTRELLA DE FAVORITOS
        if (pokemon.isFavorite) {
            holder.ivFavorite.setImageResource(R.drawable.icono_estrella_llena)
        } else {
            holder.ivFavorite.setImageResource(R.drawable.icono_estrella_vacio)
        }

        holder.ivFavorite.setOnClickListener {
            pokemon.isFavorite = !pokemon.isFavorite

            if (pokemon.isFavorite) {
                holder.ivFavorite.setImageResource(R.drawable.icono_estrella_llena)
            } else {
                holder.ivFavorite.setImageResource(R.drawable.icono_estrella_vacio)
            }
        }

        // 4. CLICK EN EL ITEM
        holder.itemView.setOnClickListener {
            val detallesFragment = DetallesFragment().apply {
                arguments = Bundle().apply {
                    putString("pokemonName", pokemon.name)
                    putInt("pokemonId", pokemon.getId())
                }
            }

            holder.itemView.context.let { context ->
                if (context is androidx.fragment.app.FragmentActivity) {
                    context.supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, detallesFragment)
                        .addToBackStack("detalles")
                        .commit()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}