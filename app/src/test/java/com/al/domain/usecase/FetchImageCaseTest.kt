package com.al.domain.usecase

import app.cash.turbine.test
import com.al.domain.mock_data.MockUtil
import com.al.domain.repository.ExploreImagesRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

@RunWith(MockitoJUnitRunner::class)
class FetchImageCaseTest {
    private val imageRepo: ExploreImagesRepository = mock()
    lateinit var sut: FetchImageCase


    @Before
    fun setup() {
        sut = FetchImageCase(imageRepo)
    }

    @ExperimentalTime
    @Test
    fun `check if mocked list and flowed list is same or not`() = runBlocking {
        val mockData = MockUtil.getMockImageResponseFlow()

        whenever((FetchImageCase(imageRepo).invoke(1))).thenReturn(mockData)

        val fetchedDataFlow = FetchImageCase(imageRepo).invoke(1).test(0.seconds) {
            Assert.assertEquals(mockData, expectItem())
            expectComplete()
        }


        fetchedDataFlow.apply {
            // runBlocking should return Unit
        }

    }

    @ExperimentalTime
    @Test
    fun `check if method called`() = runBlocking {
        whenever((FetchImageCase(imageRepo).invoke(1))).thenReturn(imageRepo.fetchImages(1))
        sut.invoke(1)
        verify(imageRepo.fetchImages(1))
    }
}