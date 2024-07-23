package com.android.pokemontcg.data.remote.api

import com.android.pokemontcg.data.local.entities.PokemonCardResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {
    @GET("cards")
    suspend fun getPokemonCards(@Query("pageSize") pageSize: Int): PokemonCardResponse
}