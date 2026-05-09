package com.example.cleanarchitecturewithmvi.domain.usecase

import com.example.cleanarchitecturewithmvi.domain.model.CoinDomainModelItem
import com.example.cleanarchitecturewithmvi.domain.repository.CoinRepository
import jakarta.inject.Inject

class ListCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke(): List<CoinDomainModelItem> {
        return coinRepository.getCoinsList().sortedBy { it.rank }
    }

}