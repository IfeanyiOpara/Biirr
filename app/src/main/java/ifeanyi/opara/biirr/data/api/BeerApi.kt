package ifeanyi.opara.biirr.data.api

import ifeanyi.opara.biirr.data.BeerDetailDto
import ifeanyi.opara.biirr.data.BeerDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BeerApi {

    @GET("v2/beers")
    suspend fun getBeers() : ArrayList<BeerDto>

    @GET("v2/beers/{beerId}")
    suspend fun getBeerDetail(
        @Path("beerId") beerId: Int
    ) : List<BeerDetailDto>

}