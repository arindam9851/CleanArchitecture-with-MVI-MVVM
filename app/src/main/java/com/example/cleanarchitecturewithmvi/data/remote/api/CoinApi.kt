package com.example.cleanarchitecturewithmvi.data.remote.api

import com.example.cleanarchitecturewithmvi.data.remote.dto.ListCoinDTO
import retrofit2.http.GET

interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<ListCoinDTO>
}