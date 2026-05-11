package com.example.cleanarchitecturewithmvi

import com.example.cleanarchitecturewithmvi.domain.usecase.ListCoinUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class ListCoinUseCaseTest {

    private lateinit var useCase: ListCoinUseCase

    @Before
    fun setup(){
        useCase = ListCoinUseCase(
            FakeCoinRepository()
        )
    }

    @Test
    fun `coin should be sorted by rank`()= runTest {
        val result = useCase()
        assertEquals(1, result.first().rank)
        assertEquals("Ethereum", result.first().name)
    }

}