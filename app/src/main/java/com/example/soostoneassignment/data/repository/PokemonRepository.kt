package com.example.soostoneassignment.data.repository

import com.example.soostoneassignment.data.remote.api.Service
import com.example.soostoneassignment.data.remote.model.PokemonModel

class PokemonRepository(private val pokemonService: Service)  {

    suspend fun getPokemonList(): List<PokemonModel> {
        val response = pokemonService.getPokemonList()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            throw Exception("Failed to fetch Pokémon list")
        }
    }
}