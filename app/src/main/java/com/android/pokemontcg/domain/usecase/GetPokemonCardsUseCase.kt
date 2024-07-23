package com.android.pokemontcg.domain.usecase

import com.android.pokemontcg.domain.model.PokemonCardDTO
import com.android.pokemontcg.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonCardsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(pageSize: Int): Flow<List<PokemonCardDTO>> {
        return repository.getPokemonCard(pageSize)
    }
}