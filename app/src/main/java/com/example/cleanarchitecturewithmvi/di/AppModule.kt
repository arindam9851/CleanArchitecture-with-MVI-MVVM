package com.example.cleanarchitecturewithmvi.di

import com.example.cleanarchitecturewithmvi.data.remote.api.CoinApi
import com.example.cleanarchitecturewithmvi.data.repository.CoinRepositoryImpl
import com.example.cleanarchitecturewithmvi.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor{
        return Interceptor{ chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                // .addHeader("Authorization", "Bearer token")
                .build()
            chain.proceed(request)

        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(headerInterceptor: Interceptor): OkHttpClient {
         return OkHttpClient.Builder()
             .addInterceptor(headerInterceptor)
             .build()

    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return  Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.coinpaprika.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(
        retrofit: Retrofit
    ): CoinApi {
        return retrofit.create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository( coinApi: CoinApi) : CoinRepository {
        return CoinRepositoryImpl(coinApi)

    }

}