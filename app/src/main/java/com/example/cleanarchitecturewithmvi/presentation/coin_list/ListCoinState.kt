package com.example.cleanarchitecturewithmvi.presentation.coin_list

import com.example.cleanarchitecturewithmvi.presentation.coin_list.model.CoinListUIModel

data class ListCoinState(
    val isLoading: Boolean = false,
    val listCoin : List<CoinListUIModel> = emptyList(),
    val error : String ?= null
)
