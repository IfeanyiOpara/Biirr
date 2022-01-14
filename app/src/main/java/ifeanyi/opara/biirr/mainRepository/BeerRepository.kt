package ifeanyi.opara.biirr.mainRepository

import ifeanyi.opara.biirr.data.BeerDetailDto
import ifeanyi.opara.biirr.data.BeerDto

interface BeerRepository {

    suspend fun getBeer() : ArrayList<BeerDto>

    suspend fun getBeerDetail(beerId : Int) : BeerDetailDto

}