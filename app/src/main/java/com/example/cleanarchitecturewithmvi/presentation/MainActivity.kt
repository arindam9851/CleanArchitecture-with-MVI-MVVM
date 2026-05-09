package com.example.cleanarchitecturewithmvi.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.cleanarchitecturewithmvi.presentation.coin_list.ListCoinScreen
import com.example.cleanarchitecturewithmvi.presentation.theme.CleanArchitectureWithMVITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanArchitectureWithMVITheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    ListCoinScreen(modifier = Modifier.Companion.padding(innerPadding))
                }
            }
        }
    }
}