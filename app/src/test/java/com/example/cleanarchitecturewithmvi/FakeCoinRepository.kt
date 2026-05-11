package com.example.cleanarchitecturewithmvi

import com.example.cleanarchitecturewithmvi.domain.model.CoinDomainModelItem
import com.example.cleanarchitecturewithmvi.domain.repository.CoinRepository

class FakeCoinRepository : CoinRepository {
    override suspend fun getCoinsList(): List<CoinDomainModelItem> {
        return listOf(
            CoinDomainModelItem(
                id = "btc-bitcoin",
                name = "Bitcoin",
                rank = 2,
                is_new = true,
                type = "",
                is_active = true
            ),
            CoinDomainModelItem(
                id = "eth-ethereum",
                name = "Ethereum",
                rank = 1,
                is_new = true,
                type = "",
                is_active = true
            )
        )
    }
}