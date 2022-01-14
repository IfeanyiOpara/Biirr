package ifeanyi.opara.biirr.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ifeanyi.opara.biirr.data.api.BeerApi
import ifeanyi.opara.biirr.mainRepository.BeerRepository
import ifeanyi.opara.biirr.repositoryImplementation.BeerRepositoryImplementation
import ifeanyi.opara.biirr.util.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): BeerApi{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BeerApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBeerRepository(api : BeerApi): BeerRepository{
        return BeerRepositoryImplementation(api)
    }

}