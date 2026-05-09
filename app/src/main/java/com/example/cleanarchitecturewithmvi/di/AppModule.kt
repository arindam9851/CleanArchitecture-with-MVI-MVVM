package com.example.cleanarchitecturewithmvi.di

import com.example.cleanarchitecturewithmvi.data.remote.api.CoinApi
import com.example.cleanarchitecturewithmvi.data.repository.CoinRepositoryImpl
import com.example.cleanarchitecturewithmvi.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofit(): CoinApi {
        return Retrofit.Builder()
            .baseUrl("https://api.coinpaprika.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)

    }

    @Provides
    @Singleton
    fun provideRepository( coinApi: CoinApi) : CoinRepository {
        return CoinRepositoryImpl(coinApi)

    }

}