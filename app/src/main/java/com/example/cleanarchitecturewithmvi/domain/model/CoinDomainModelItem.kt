package com.example.cleanarchitecturewithmvi.domain.model

data class CoinDomainModelItem(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val type: String
)