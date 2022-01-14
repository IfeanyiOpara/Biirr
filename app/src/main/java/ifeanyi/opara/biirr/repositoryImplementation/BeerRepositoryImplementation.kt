package ifeanyi.opara.biirr.repositoryImplementation

import ifeanyi.opara.biirr.data.BeerDetailDto
import ifeanyi.opara.biirr.data.BeerDto
import ifeanyi.opara.biirr.data.api.BeerApi
import ifeanyi.opara.biirr.mainRepository.BeerRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeerRepositoryImplementation
    @Inject constructor(private val beerApi: BeerApi): BeerRepository{

    override suspend fun getBeer(): ArrayList<BeerDto> {
        return beerApi.getBeers()
    }

    override suspend fun getBeerDetail(beerId: Int): BeerDetailDto {
        return beerApi.getBeerDetail(beerId)[0]
    }
}