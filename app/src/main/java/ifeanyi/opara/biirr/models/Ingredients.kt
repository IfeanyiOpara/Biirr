package ifeanyi.opara.biirr.models

data class Ingredients(
    val hops: List<Hop>,
    val malt: List<Malt>,
    val yeast: String
)