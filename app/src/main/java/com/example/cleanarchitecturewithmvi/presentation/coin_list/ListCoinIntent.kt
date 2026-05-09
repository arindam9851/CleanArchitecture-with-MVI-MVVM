package com.example.cleanarchitecturewithmvi.presentation.coin_list

sealed class ListCoinIntent {
    object ListOfCoins : ListCoinIntent()

}