package com.example.soostoneassignment.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.soostoneassignment.R
import com.example.soostoneassignment.data.remote.model.PokemonModel

@Composable
fun PokemonDetailComposable(
    navController: NavController,
    pokemonDetail: PokemonModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TopAppBarWithBackButton(
            title = pokemonDetail.name,
            onBackClick = { navController.popBackStack() }
        )
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pokemonDetail.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = pokemonDetail.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}

@Composable
fun TopAppBarWithBackButton(title: String, onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(color = Color(R.color.purple_500))
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 16.dp, top = 20.dp)
                .clickable { onBackClick() },
            tint = Color.White,
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(start = 66.dp, top = 18.dp),
            text = title,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.titleMedium
        )
    }
}