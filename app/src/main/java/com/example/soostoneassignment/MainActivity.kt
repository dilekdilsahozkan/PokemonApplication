package com.example.soostoneassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import com.example.soostoneassignment.data.remote.api.Service
import com.example.soostoneassignment.data.remote.model.PokemonModel
import com.example.soostoneassignment.data.repository.PokemonRepository
import com.example.soostoneassignment.presentation.navigation.AppNavigationGraph
import com.example.soostoneassignment.presentation.viewmodel.PokemonViewModel
import com.example.soostoneassignment.presentation.viewmodel.PokemonViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)

        val repository = PokemonRepository(service)
        viewModel = ViewModelProvider(this, PokemonViewModelFactory(repository)).get(PokemonViewModel::class.java)

        setContent {
            val pokemonList = viewModel.pokemonList.value
            if (pokemonList.isNotEmpty()) {
                AppEntryPoint(pokemonList)
            } else {
            }
        }
    }
}

@Composable
fun AppEntryPoint(pokemonList: List<PokemonModel>){
    AppNavigationGraph(pokemonList)
}
