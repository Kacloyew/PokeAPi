package com.example.pokeapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokeapi.databinding.FragmentDetallesBinding  // ← CAMBIADO

class DetallesFragment : Fragment() {

    // ViewBinding con el nombre CORRECTO
    private var _binding: FragmentDetallesBinding? = null  // ← CAMBIADO
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar el layout con el nombre CORRECTO
        _binding = FragmentDetallesBinding.inflate(inflater, container, false)  // ← CAMBIADO
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar los datos
        binding.textPokemonName.text = "Pikachu"
        binding.textPokemonId.text = "ID: 25"
        binding.textPokemonDescription.text = "Un Pokémon ratón eléctrico amarillo"

        // Configurar el botón de volver
        binding.buttonBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}