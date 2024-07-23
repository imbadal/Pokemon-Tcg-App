package com.android.pokemontcg.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.android.pokemontcg.BuildConfig
import com.android.pokemontcg.data.local.dao.PokemonDao
import com.android.pokemontcg.data.local.database.AppDatabase
import com.android.pokemontcg.data.remote.api.PokemonApiService
import com.android.pokemontcg.data.repository.PokemonRepositoryImpl
import com.android.pokemontcg.domain.repository.PokemonRepository
import com.android.pokemontcg.domain.usecase.GetPokemonCardsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindPokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository

    companion object {

        @Provides
        @Singleton
        fun providePokemonService(): PokemonApiService {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonApiService::class.java)
        }

        @Provides
        @Singleton
        fun provideGetPokemonCardsUseCase(
            repository: PokemonRepository
        ): GetPokemonCardsUseCase {
            return GetPokemonCardsUseCase(repository)
        }

        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
            return Room.databaseBuilder(
                appContext,
                AppDatabase::class.java,
                BuildConfig.POKEMON_DB
            ).build()
        }

        @Provides
        fun providePokemonDao(db: AppDatabase): PokemonDao {
            return db.pokemonDao()
        }

        @Provides
        @Singleton
        fun provideSharedPreferences(@ApplicationContext appContext: Context): SharedPreferences {
            return appContext.getSharedPreferences(BuildConfig.APP_PREFS, Context.MODE_PRIVATE)
        }
    }
}