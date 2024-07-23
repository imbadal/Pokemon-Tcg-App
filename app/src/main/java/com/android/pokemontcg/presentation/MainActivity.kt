package com.android.pokemontcg.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.pokemontcg.presentation.ui.screens.PokemonDetailScreen
import com.android.pokemontcg.presentation.ui.screens.PokemonListScreen
import com.android.pokemontcg.presentation.viewmodel.PokemonListingViewModel
import com.android.pokemontcg.presentation.ui.theme.PokemonTcgTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonTcgTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val pokemonViewModel: PokemonListingViewModel = viewModel()

                    NavHost(navController = navController, startDestination = "pokemon_list") {
                        composable("pokemon_list") {
                            PokemonListScreen(navController = navController)
                        }
                        composable("pokemon_details/{pokemonId}") { backStackEntry ->
                            val pokemonId: String = backStackEntry.arguments?.getString("pokemonId") ?: ""
                            PokemonDetailScreen(pokemon = pokemonViewModel.getPokemonById(pokemonId)) { navController.popBackStack() }
                        }
                    }
                }
            }
        }
    }
}


