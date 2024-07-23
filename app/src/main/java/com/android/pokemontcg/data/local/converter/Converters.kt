package com.android.pokemontcg.data.local.converter

import androidx.room.TypeConverter
import com.android.pokemontcg.domain.model.AttackDTO
import com.android.pokemontcg.domain.model.ResistanceDTO
import com.android.pokemontcg.domain.model.WeaknessDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        return value?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        return value?.let { Gson().fromJson(it, object : TypeToken<List<String>>() {}.type) }
    }

    @TypeConverter
    fun fromAttackList(value: List<AttackDTO>?): String? {
        return value?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toAttackList(value: String?): List<AttackDTO>? {
        return value?.let { Gson().fromJson(it, object : TypeToken<List<AttackDTO>>() {}.type) }
    }

    @TypeConverter
    fun fromWeaknessList(value: List<WeaknessDTO>?): String? {
        return value?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toWeaknessList(value: String?): List<WeaknessDTO>? {
        return value?.let { Gson().fromJson(it, object : TypeToken<List<WeaknessDTO>>() {}.type) }
    }

    @TypeConverter
    fun fromResistanceList(value: List<ResistanceDTO>?): String? {
        return value?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toResistanceList(value: String?): List<ResistanceDTO>? {
        return value?.let { Gson().fromJson(it, object : TypeToken<List<ResistanceDTO>>() {}.type) }
    }
}
