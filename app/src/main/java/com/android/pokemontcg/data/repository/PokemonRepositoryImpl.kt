package com.android.pokemontcg.data.repository

import android.content.SharedPreferences
import com.android.pokemontcg.data.local.dao.PokemonDao
import com.android.pokemontcg.data.local.mapper.EntityMapper.toDTO
import com.android.pokemontcg.data.remote.api.PokemonApiService
import com.android.pokemontcg.utils.Consts.lastFetchTimeKey
import com.android.pokemontcg.domain.model.PokemonCardDTO
import com.android.pokemontcg.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonDao: PokemonDao,
    private val apiService: PokemonApiService,
    private val sharedPreferences: SharedPreferences
) : PokemonRepository {

    override fun getPokemonCard(pageSize: Int): Flow<List<PokemonCardDTO>> = flow {

        val lastFetchTime = sharedPreferences.getLong(lastFetchTimeKey, 0L)
        val currentTime = System.currentTimeMillis()

        emit(if (currentTime - lastFetchTime > 1 * 60 * 1000) {
            val response = apiService.getPokemonCards(pageSize)
            val pokemonEntities = response.data?.map { it.toDTO() } ?: listOf()
            pokemonDao.insertAll(pokemonEntities)
            sharedPreferences.edit().putLong(lastFetchTimeKey, currentTime).apply()
            pokemonEntities
        } else {
            pokemonDao.getAllPokemon()
        })
    }
}