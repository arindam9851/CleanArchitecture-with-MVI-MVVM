package com.example.cleanarchitecturewithmvi.data.mapper

import com.example.cleanarchitecturewithmvi.data.remote.dto.ListCoinDTO
import com.example.cleanarchitecturewithmvi.domain.model.CoinDomainModelItem

fun ListCoinDTO.toDomain(): CoinDomainModelItem{
    return CoinDomainModelItem(
        id = id,
        is_active = is_active,
        is_new = is_new,
        name = name,
        rank = rank,
        type = type
    )
}