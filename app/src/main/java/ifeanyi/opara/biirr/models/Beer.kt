package ifeanyi.opara.biirr.models

import java.io.Serializable

data class Beer(

    val id: Int,
    val image_url: String,
    val name: String,
    val tagLine : String

) : Serializable