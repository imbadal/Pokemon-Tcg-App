package com.android.pokemontcg.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.pokemontcg.data.local.converter.Converters
import com.android.pokemontcg.data.local.dao.PokemonDao
import com.android.pokemontcg.domain.model.PokemonCardDTO

@Database(entities = [PokemonCardDTO::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}
