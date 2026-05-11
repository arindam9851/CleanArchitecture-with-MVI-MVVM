package com.example.cleanarchitecturewithmvi

import app.cash.turbine.test
import com.example.cleanarchitecturewithmvi.domain.usecase.ListCoinUseCase
import com.example.cleanarchitecturewithmvi.presentation.coin_list.ListCoinIntent
import com.example.cleanarchitecturewithmvi.presentation.coin_list.ListCoinViewModelMVI
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ListCoinViewModelMVITest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: ListCoinViewModelMVI

    @Before
    fun setup(){
        val useCase = ListCoinUseCase(
            FakeCoinRepository()
        )
        viewModel = ListCoinViewModelMVI(useCase)
    }

    @Test
    fun `fetch coin should update state with coin`()= runTest {
        viewModel.handleIntent(ListCoinIntent.ListOfCoins)
        advanceUntilIdle()

        val state = viewModel.state.value
        assertFalse(state.isLoading)
        assertTrue(state.listCoin.isNotEmpty())
    }
    @Test
    fun `state emits loading then success`() = runTest {

        viewModel.state.test {

            val initial = awaitItem()
            viewModel.handleIntent(
                ListCoinIntent.ListOfCoins
            )
            val loading = awaitItem()
            assertTrue(loading.isLoading)
            val success = awaitItem()
            assertFalse(success.isLoading)
            assertTrue(success.listCoin.isNotEmpty())
        }
    }
}