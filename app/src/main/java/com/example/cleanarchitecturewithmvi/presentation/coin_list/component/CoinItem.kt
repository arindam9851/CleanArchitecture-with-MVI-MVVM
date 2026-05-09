package com.example.cleanarchitecturewithmvi.presentation.coin_list.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cleanarchitecturewithmvi.presentation.coin_list.model.CoinListUIModel

@Composable
fun CoinItems(
    coin: CoinListUIModel,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){

       Text(
           text = coin.name,
           modifier = Modifier.weight(1f)
       )

        Text(
            text = coin.type,
        )
    }

}
