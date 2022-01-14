package ifeanyi.opara.biirr.data

import ifeanyi.opara.biirr.models.*

data class BeerDto(
    val abv: Double,
    val attenuation_level: Double,
    val boil_volume: BoilVolumeX,
    val brewers_tips: String,
    val contributed_by: String,
    val description: String,
    val ebc: Int,
    val first_brewed: String,
    val food_pairing: List<String>,
    val ibu: Double,
    val id: Int,
    val image_url: String,
    val ingredients: IngredientsX,
    val method: MethodX,
    val name: String,
    val ph: Double,
    val srm: Double,
    val tagline: String,
    val target_fg: Int,
    val target_og: Double,
    val volume: VolumeX
)

fun BeerDto.toBeer() : Beer {
    return Beer(
        id = id,
        image_url = image_url,
        name = name,
        tagLine = tagline
    )
}