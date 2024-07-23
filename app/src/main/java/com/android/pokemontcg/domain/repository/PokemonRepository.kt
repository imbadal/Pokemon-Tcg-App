package com.android.pokemontcg.domain.repository

import com.android.pokemontcg.domain.model.PokemonCardDTO
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemonCard(pageSize: Int): Flow<List<PokemonCardDTO>>
}