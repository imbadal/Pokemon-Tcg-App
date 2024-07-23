package com.android.pokemontcg.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.android.pokemontcg.R
import com.android.pokemontcg.domain.model.PokemonCardDTO

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(pokemon: PokemonCardDTO, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = pokemon.name ?: "Unknown") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = rememberImagePainter(
                        data = pokemon.image,
                        builder = {
                            placeholder(R.drawable.error_image)
                            error(R.drawable.error_image)
                        }
                    ),
                    contentDescription = pokemon.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = pokemon.name ?: "Unknown",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Types: ${pokemon.types?.joinToString(", ")}",
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Sub Types: ${pokemon.subTypes?.joinToString(", ")}",
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "HP: ${pokemon.hp}",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Attacks",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    pokemon.attacks?.forEach { attack ->
                        Text(
                            text = "${attack.name} - ${attack.damage} damage",
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Weaknesses",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    pokemon.weaknesses?.forEach { weakness ->
                        Text(
                            text = "${weakness.type} - ${weakness.value}",
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
