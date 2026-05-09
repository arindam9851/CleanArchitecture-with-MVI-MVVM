package com.example.cleanarchitecturewithmvi.presentation.coin_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cleanarchitecturewithmvi.presentation.coin_list.component.CoinItems


@Composable
fun ListCoinScreen(
    viewModel: ListCoinViewModelMVI = hiltViewModel(),
    modifier: Modifier
){
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit){
        viewModel.handleIntent(ListCoinIntent.ListOfCoins)
    }

    when{
        state.isLoading -> {
            Text(text = "Loading")
        }
        state.error?.isNotBlank() == true -> {
            Text(text = state.error.toString())
        }
        else -> {
            LazyColumn{
                items(state.listCoin) { coin ->
                    CoinItems(coin = coin,modifier = modifier)
                }
            }
        }

    }
}