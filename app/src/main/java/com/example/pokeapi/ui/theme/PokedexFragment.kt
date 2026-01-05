package com.example.pokeapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.R
import com.example.pokeapi.databinding.FragmentPokedexBinding
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.ui.adapter.PokemonAdapter

class PokedexFragment : Fragment() {

    private var _binding: FragmentPokedexBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PokemonAdapter

    private val pokemonList = mutableListOf(
        Pokemon(1, "Pikachu", "Ratón eléctrico amarillo"),
        Pokemon(2, "Charizard", "Dragón de fuego volador"),
        Pokemon(3, "Bulbasaur", "Semilla dinosaurio"),
        Pokemon(4, "Squirtle", "Tortuga acuática"),
        Pokemon(5, "Jigglypuff", "Globo cantante")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokedexBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupSwipeToDelete()
    }

    private fun setupRecyclerView() {
        adapter = PokemonAdapter(pokemonList) { pokemon ->

            // Cuando se hace click en un Pokémon
            val detailsFragment = DetallesFragment()

            // Cambiar al fragmento de detalles
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailsFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun setupSwipeToDelete() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val position = viewHolder.adapterPosition

                // Eliminar el Pokémon de la lista
                pokemonList.removeAt(position)

                // Notificar al adapter que se eliminó un item
                adapter.notifyItemRemoved(position)

            }
        }).attachToRecyclerView(binding.recyclerView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}