package com.android.pokemontcg.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.pokemontcg.domain.model.PokemonCardDTO

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    suspend fun getAllPokemon(): List<PokemonCardDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemon: List<PokemonCardDTO>)

    @Query("SELECT * FROM pokemon WHERE id = :id")
    suspend fun getPokemonById(id: String): PokemonCardDTO?
}