package com.example.soostoneassignment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.soostoneassignment.data.remote.model.PokemonModel
import com.example.soostoneassignment.presentation.ui.PokemonDetailComposable
import com.example.soostoneassignment.presentation.ui.PokemonListComposable

@Composable
fun AppNavigationGraph(
    pokemonList: List<PokemonModel>
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            PokemonListComposable(navController, pokemonList = pokemonList)
        }
        composable("detail/{pokemonName}") { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName")
            if (pokemonName != null) {
                val selectedPokemon = pokemonList.find { it.name == pokemonName }
                if (selectedPokemon != null) {
                    PokemonDetailComposable(navController, pokemonDetail = selectedPokemon)
                }
            }
        }
    }
}
