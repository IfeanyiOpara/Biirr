package ifeanyi.opara.biirr.models

data class Method(
    val fermentation: Fermentation,
    val mash_temp: List<MashTemp>,
    val twist: Any
)