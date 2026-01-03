package com.example.pokeapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokeapi.databinding.MainBinding
import com.example.pokeapi.ui.PokedexFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar el fragmento inicial
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PokedexFragment())
                .commit()
        }
    }
}