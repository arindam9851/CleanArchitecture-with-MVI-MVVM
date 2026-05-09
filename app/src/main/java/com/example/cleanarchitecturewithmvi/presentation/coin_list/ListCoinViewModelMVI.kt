package com.example.cleanarchitecturewithmvi.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturewithmvi.domain.usecase.ListCoinUseCase
import com.example.cleanarchitecturewithmvi.presentation.coin_list.mapper.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ListCoinViewModelMVI @Inject constructor(
    private val useCase: ListCoinUseCase
) : ViewModel() {

    private val  _state = MutableStateFlow(ListCoinState())
    val state : StateFlow<ListCoinState> = _state


    fun handleIntent (intent : ListCoinIntent){
        when(intent) {
            is ListCoinIntent.ListOfCoins -> getCoinList()
        }
    }

    fun getCoinList() {
        viewModelScope.launch {
            //Loading State
            _state.value = _state.value.copy(
                isLoading = true,
                error = null

            )

            try {
                val response = useCase()
                val uiModel = response.map { it.toUI() }

                _state.value = _state.value.copy(
                    isLoading = false,
                    listCoin = uiModel
                )



            }
            catch (e:Exception){
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }

        }

    }
}