package com.android.pokemontcg.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonCardDTO(
    @PrimaryKey
    val id: String,
    val image: String?,
    val name: String?,
    val types: List<String>?,
    val subTypes: List<String>?,
    val level: String?,
    val hp: Int?,
    val attacks: List<AttackDTO>?,
    val weaknesses: List<WeaknessDTO>?,
    val resistances: List<ResistanceDTO>?
)

data class AttackDTO(
    val name: String?,
    val cost: List<String>?,
    val damage: String?,
    val text: String?
)

data class WeaknessDTO(
    val type: String?,
    val value: String?
)

data class ResistanceDTO(
    val type: String?,
    val value: String?
)
