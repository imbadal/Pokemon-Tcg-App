package com.android.pokemontcg.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.android.pokemontcg.presentation.ui.bottomsheet.SortOption
import com.android.pokemontcg.presentation.ui.widgets.HeaderBar
import com.android.pokemontcg.presentation.ui.widgets.PokemonCardItem
import com.android.pokemontcg.presentation.ui.widgets.ShimmerLayoutHome
import com.android.pokemontcg.presentation.viewmodel.PokemonListingViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun PokemonListScreen(
    viewModel: PokemonListingViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val searchQuery = remember { mutableStateOf(TextFieldValue("")) }
    val pokemonCards = viewModel.filteredPokemonList.collectAsState()
    val isSearchEnabled = remember { mutableStateOf(false) }
    val isLoading by viewModel.isLoading.collectAsState()
    val selectedSortOption = remember { mutableStateOf(SortOption.LevelAsc) }

    LaunchedEffect(searchQuery.value) {
        viewModel.updateSearchQuery(searchQuery.value.text)
    }

    Column {

        HeaderBar(
            searchQuery = searchQuery,
            isSearchEnabled = isSearchEnabled,
            onSortOptionSelected = { selectedOption ->
                viewModel.sortPokemons(selectedOption)
                selectedSortOption.value = selectedOption
            },
            selectedSortOption.value,
            viewModel.lastSyncTime.value
        )

        if (isLoading) {
            LazyColumn(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                items(10) {
                    ShimmerLayoutHome()
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                items(pokemonCards.value) { card ->
                    PokemonCardItem(card, onCardClick = {
                        navController.navigate("pokemon_details/${card.id}")
                    })
                }
            }
        }
    }
}


