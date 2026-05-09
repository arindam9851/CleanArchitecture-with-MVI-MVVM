package com.example.cleanarchitecturewithmvi.presentation.coin_list.model

data class CoinListUIModel(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: String,
    val type: String
)
