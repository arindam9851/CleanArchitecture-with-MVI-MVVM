package com.example.cleanarchitecturewithmvi.domain.repository

import com.example.cleanarchitecturewithmvi.domain.model.CoinDomainModelItem

interface CoinRepository {
    suspend fun getCoinsList():List<CoinDomainModelItem>
}