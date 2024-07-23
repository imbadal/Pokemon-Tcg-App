package com.android.pokemontcg.data.local.mapper

import com.android.pokemontcg.data.local.entities.Attack
import com.android.pokemontcg.data.local.entities.PokemonCard
import com.android.pokemontcg.data.local.entities.Resistance
import com.android.pokemontcg.data.local.entities.Weakness
import com.android.pokemontcg.domain.model.AttackDTO
import com.android.pokemontcg.domain.model.PokemonCardDTO
import com.android.pokemontcg.domain.model.ResistanceDTO
import com.android.pokemontcg.domain.model.WeaknessDTO

object EntityMapper {

    fun PokemonCard.toDTO(): PokemonCardDTO {
        return PokemonCardDTO(
            id = this.id,
            image = this.images?.large,
            name = this.name,
            types = this.types,
            subTypes = this.subtypes,
            level = this.id,
            hp = this.hp,
            attacks = this.attacks?.map { it.toDTO() },
            weaknesses = this.weaknesses?.map { it.toDTO() },
            resistances = this.resistances?.map { it.toDTO() }
        )
    }

    fun Attack.toDTO(): AttackDTO {
        return AttackDTO(
            name = this.name,
            cost = this.cost,
            damage = this.damage,
            text = this.text
        )
    }

    fun Weakness.toDTO(): WeaknessDTO {
        return WeaknessDTO(
            type = this.type,
            value = this.value
        )
    }

    fun Resistance.toDTO(): ResistanceDTO {
        return ResistanceDTO(
            type = this.type,
            value = this.value
        )
    }
}