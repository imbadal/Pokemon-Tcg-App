package com.android.pokemontcg.presentation.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.pokemontcg.domain.model.PokemonCardDTO
import com.android.pokemontcg.domain.usecase.GetPokemonCardsUseCase
import com.android.pokemontcg.presentation.ui.bottomsheet.SortOption
import com.android.pokemontcg.utils.AppUtils.formatTimestamp
import com.android.pokemontcg.utils.Consts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListingViewModel @Inject constructor(
    private val pokemonCardsUseCase: GetPokemonCardsUseCase,
    private val sharedPreferences: SharedPreferences

) : ViewModel() {

    private val _pokemonCards = MutableStateFlow<List<PokemonCardDTO>>(emptyList())

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _searchQuery = MutableStateFlow("")

    private val _filteredPokemonList = MutableStateFlow(_pokemonCards.value)
    val filteredPokemonList: MutableStateFlow<List<PokemonCardDTO>> = _filteredPokemonList

    private val _lastSyncTime = MutableLiveData<String>()
    val lastSyncTime: LiveData<String> get() = _lastSyncTime

    init {
        fetchPokemonCards()
        updateLastSyncTime()

        viewModelScope.launch {
            combine(_pokemonCards, _searchQuery) { list, query ->
                if (query.isBlank() || query.length < 3) {
                    list
                } else {
                    list.filter { it.name?.contains(query, ignoreCase = true) == true }
                }
            }.collect { _filteredPokemonList.value = it }
        }

    }

    private fun fetchPokemonCards() {
        viewModelScope.launch {
            _isLoading.value = true

            pokemonCardsUseCase(20)
                .catch { e ->
                    e.printStackTrace()
                }
                .collect { cards ->
                    _pokemonCards.value = cards
                    sortPokemons(SortOption.LevelAsc)
                }

            _isLoading.value = false
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun sortPokemons(selectedSortOption: SortOption) {
        when (selectedSortOption) {
            SortOption.LevelAsc -> {
                filteredPokemonList.value =
                    filteredPokemonList.value.sortedBy { it.id }
            }

            SortOption.LevelDesc -> {
                filteredPokemonList.value =
                    filteredPokemonList.value.sortedByDescending { it.id }
            }

            SortOption.HpAsc -> {
                filteredPokemonList.value =
                    filteredPokemonList.value.sortedBy { it.hp }
            }

            SortOption.HpDesc -> {
                filteredPokemonList.value =
                    filteredPokemonList.value.sortedByDescending { it.hp }
            }
        }
    }

    fun getPokemonById(pokemonId: String): PokemonCardDTO {
        return _pokemonCards.value.first { it.id == pokemonId }
    }

    private fun updateLastSyncTime() {
        val lastFetchTime = sharedPreferences.getLong(Consts.lastFetchTimeKey, 0L)
        _lastSyncTime.postValue(formatTimestamp(lastFetchTime))
    }
}