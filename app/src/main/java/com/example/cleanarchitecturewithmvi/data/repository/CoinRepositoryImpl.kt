package com.example.cleanarchitecturewithmvi.data.repository

import com.example.cleanarchitecturewithmvi.data.mapper.toDomain
import com.example.cleanarchitecturewithmvi.data.remote.api.CoinApi
import com.example.cleanarchitecturewithmvi.domain.model.CoinDomainModelItem
import com.example.cleanarchitecturewithmvi.domain.repository.CoinRepository
import jakarta.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {
    override suspend fun getCoinsList(): List<CoinDomainModelItem> {
        return api.getCoins().map { it.toDomain() }
    }
}