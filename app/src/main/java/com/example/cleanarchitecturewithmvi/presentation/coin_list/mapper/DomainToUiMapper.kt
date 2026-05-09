package com.example.cleanarchitecturewithmvi.presentation.coin_list.mapper

import com.example.cleanarchitecturewithmvi.domain.model.CoinDomainModelItem
import com.example.cleanarchitecturewithmvi.presentation.coin_list.model.CoinListUIModel

fun CoinDomainModelItem.toUI() : CoinListUIModel {
    return CoinListUIModel(
        id = id,
        is_active = is_active,
        is_new = is_new,
        name = name,
        rank = rank.toString(),
        type = type
    )
}