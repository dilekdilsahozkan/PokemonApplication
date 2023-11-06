package com.example.soostoneassignment.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.soostoneassignment.data.remote.model.PokemonModel
import com.example.soostoneassignment.data.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel constructor(private val repository: PokemonRepository) : ViewModel() {

    val pokemonList = mutableStateOf<List<PokemonModel>>(emptyList())

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = repository.getPokemonList()
                pokemonList.value = data
            } catch (e: Exception) {

            }
        }
    }
}

class PokemonViewModelFactory(private val repository: PokemonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
            return PokemonViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}



