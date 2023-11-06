package com.example.soostoneassignment.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.soostoneassignment.data.remote.model.PokemonModel
import coil.request.ImageRequest
import com.example.soostoneassignment.R

@Composable
fun PokemonListComposable(
    navController: NavController,
    pokemonList: List<PokemonModel>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TopAppBar(title = "Pokémon")
        }
        items(pokemonList) { pokemon ->
            PokemonItem(navController, pokemonList = pokemon)
        }
    }
}

@Composable
fun PokemonItem(
    navController: NavController,
    pokemonList: PokemonModel
) {
    Box(
        modifier = Modifier
            .clickable {
                navController.navigate("detail/${pokemonList.name}") {
                }
            }
    ) {
        Row(
            modifier = Modifier
                .padding(0.dp,10.dp,10.dp,0.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemonList.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
            )
            Column {
                Text(
                    text = pokemonList.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = pokemonList.description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun TopAppBar(title: String) {
    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(color = Color(R.color.purple_500))
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 26.dp, top = 18.dp),
            text = title,
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

