package com.android.pokemontcg.data.local.entities

import com.google.gson.annotations.SerializedName

data class PokemonCardResponse(
    @SerializedName("data") val data: List<PokemonCard>? = null,
    @SerializedName("page") val page: Int? = null,
    @SerializedName("pageSize") val pageSize: Int? = null,
    @SerializedName("count") val count: Int? = null,
    @SerializedName("totalCount") val totalCount: Int? = null
)

data class PokemonCard(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String? = null,
    @SerializedName("supertype") val supertype: String? = null,
    @SerializedName("subtypes") val subtypes: List<String>? = null,
    @SerializedName("hp") val hp: Int? = null,
    @SerializedName("types") val types: List<String>? = null,
    @SerializedName("evolvesFrom") val evolvesFrom: String? = null,
    @SerializedName("evolvesTo") val evolvesTo: List<String>? = null,
    @SerializedName("attacks") val attacks: List<Attack>? = null,
    @SerializedName("weaknesses") val weaknesses: List<Weakness>? = null,
    @SerializedName("resistances") val resistances: List<Resistance>? = null,
    @SerializedName("retreatCost") val retreatCost: List<String>? = null,
    @SerializedName("convertedRetreatCost") val convertedRetreatCost: Int? = null,
    @SerializedName("set") val set: CardSet? = null,
    @SerializedName("number") val number: String? = null,
    @SerializedName("artist") val artixst: String? = null,
    @SerializedName("rarity") val rarity: String? = null,
    @SerializedName("flavorText") val flavorText: String? = null,
    @SerializedName("nationalPokedexNumbers") val nationalPokedexNumbers: List<Int>? = null,
    @SerializedName("legalities") val legalities: Legalities? = null,
    @SerializedName("images") val images: Images? = null,
    @SerializedName("tcgplayer") val tcgplayer: Tcgplayer? = null,
    @SerializedName("cardmarket") val cardmarket: Cardmarket? = null
)

data class Attack(
    @SerializedName("name") val name: String? = null,
    @SerializedName("cost") val cost: List<String>? = null,
    @SerializedName("convertedEnergyCost") val convertedEnergyCost: Int? = null,
    @SerializedName("damage") val damage: String? = null,
    @SerializedName("text") val text: String? = null
)

data class Weakness(
    @SerializedName("type") val type: String? = null,
    @SerializedName("value") val value: String? = null
)

data class Resistance(
    @SerializedName("type") val type: String? = null,
    @SerializedName("value") val value: String? = null
)

data class CardSet(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("series") val series: String? = null,
    @SerializedName("printedTotal") val printedTotal: Int? = null,
    @SerializedName("total") val total: Int? = null,
    @SerializedName("legalities") val legalities: Legalities? = null,
    @SerializedName("ptcgoCode") val ptcgoCode: String? = null,
    @SerializedName("releaseDate") val releaseDate: String? = null,
    @SerializedName("updatedAt") val updatedAt: String? = null,
    @SerializedName("images") val images: SetImages? = null
)

data class Legalities(
    @SerializedName("unlimited") val unlimited: String? = null,
    @SerializedName("expanded") val expanded: String? = null
)

data class Images(
    @SerializedName("small") val small: String? = null,
    @SerializedName("large") val large: String? = null
)

data class SetImages(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("logo") val logo: String? = null
)

data class Tcgplayer(
    @SerializedName("url") val url: String? = null,
    @SerializedName("updatedAt") val updatedAt: String? = null,
    @SerializedName("prices") val prices: Prices? = null
)

data class Prices(
    @SerializedName("holofoil") val holofoil: Holofoil? = null,
    @SerializedName("reverseHolofoil") val reverseHolofoil: ReverseHolofoil? = null,
    @SerializedName("normal") val normal: Normal? = null,
    @SerializedName("1stEditionHolofoil") val firstEditionHolofoil: FirstEditionHolofoil? = null,
    @SerializedName("unlimitedHolofoil") val unlimitedHolofoil: UnlimitedHolofoil? = null
)

data class Holofoil(
    @SerializedName("low") val low: Double? = null,
    @SerializedName("mid") val mid: Double? = null,
    @SerializedName("high") val high: Double? = null,
    @SerializedName("market") val market: Double? = null,
    @SerializedName("directLow") val directLow: Double? = null
)

data class ReverseHolofoil(
    @SerializedName("low") val low: Double? = null,
    @SerializedName("mid") val mid: Double? = null,
    @SerializedName("high") val high: Double? = null,
    @SerializedName("market") val market: Double? = null,
    @SerializedName("directLow") val directLow: Double? = null
)

data class Normal(
    @SerializedName("low") val low: Double? = null,
    @SerializedName("mid") val mid: Double? = null,
    @SerializedName("high") val high: Double? = null,
    @SerializedName("market") val market: Double? = null,
    @SerializedName("directLow") val directLow: Double? = null
)

data class FirstEditionHolofoil(
    @SerializedName("low") val low: Double? = null,
    @SerializedName("mid") val mid: Double? = null,
    @SerializedName("high") val high: Double? = null,
    @SerializedName("market") val market: Double? = null,
    @SerializedName("directLow") val directLow: Double? = null
)

data class UnlimitedHolofoil(
    @SerializedName("low") val low: Double? = null,
    @SerializedName("mid") val mid: Double? = null,
    @SerializedName("high") val high: Double? = null,
    @SerializedName("market") val market: Double? = null,
    @SerializedName("directLow") val directLow: Double? = null
)

data class Cardmarket(
    @SerializedName("url") val url: String? = null,
    @SerializedName("updatedAt") val updatedAt: String? = null,
    @SerializedName("prices") val prices: MarketPrices? = null
)

data class MarketPrices(
    @SerializedName("averageSellPrice") val averageSellPrice: Double? = null,
    @SerializedName("lowPrice") val lowPrice: Double? = null,
    @SerializedName("trendPrice") val trendPrice: Double? = null,
    @SerializedName("germanProLow") val germanProLow: Double? = null,
    @SerializedName("suggestedPrice") val suggestedPrice: Double? = null,
    @SerializedName("reverseHoloSell") val reverseHoloSell: Double? = null,
    @SerializedName("reverseHoloLow") val reverseHoloLow: Double? = null,
    @SerializedName("reverseHoloTrend") val reverseHoloTrend: Double? = null,
    @SerializedName("lowPriceExPlus") val lowPriceExPlus: Double? = null,
    @SerializedName("avg1") val avg1: Double? = null,
    @SerializedName("avg7") val avg7: Double? = null,
    @SerializedName("avg30") val avg30: Double? = null,
    @SerializedName("reverseHoloAvg1") val reverseHoloAvg1: Double? = null,
    @SerializedName("reverseHoloAvg7") val reverseHoloAvg7: Double? = null,
    @SerializedName("reverseHoloAvg30") val reverseHoloAvg30: Double? = null
)
