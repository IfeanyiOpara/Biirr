package ifeanyi.opara.biirr.data

import ifeanyi.opara.biirr.models.*

data class BeerDetailDto(
    val abv: Double,
    val attenuation_level: Double?,
    val boil_volume: BoilVolume,
    val brewers_tips: String,
    val contributed_by: String,
    val description: String,
    val ebc: Double,
    val first_brewed: String,
    val food_pairing: List<String>,
    val ibu: Double,
    val id: Double?,
    val image_url: String,
    val ingredients: Ingredients,
    val method: Method,
    val name: String,
    val ph: Double,
    val srm: Double?,
    val tagline: String,
    val target_fg: Double?,
    val target_og: Double?,
    val volume: Volume
)

fun BeerDetailDto.toBeerDetail() : BeerDetail{
    return BeerDetail(
        description = description,
        abv = abv,
        ibu = ibu
    )
}