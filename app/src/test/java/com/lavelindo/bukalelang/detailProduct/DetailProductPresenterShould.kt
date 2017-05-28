package com.lavelindo.bukalelang.detailProduct

import com.lavelindo.bukalelang.TestMainThread
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutorImpl
import com.lavelindo.bukalelang.common.domain.repository.BidRepository
import com.lavelindo.bukalelang.detailProduct.domain.BidProductUsecase
import com.lavelindo.bukalelang.detailProduct.domain.DetailsProduct
import com.lavelindo.bukalelang.detailProduct.domain.DetailsProductRepository
import com.lavelindo.bukalelang.detailProduct.domain.GetProductDetailsUsecase
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by sujarwe on 5/27/17.
 */
class DetailProductPresenterShould {
    lateinit var presenter: DetailProductPresenter
    val view = mock<DetailsProductView>()
    val detailsProductRepository = mock<DetailsProductRepository>()
    val bidRepository = mock<BidRepository>()
    val productCaptor = argumentCaptor<DetailsProduct>()

    @Before
    fun setUp() {
        val mainThread = TestMainThread()
        val useCaseExecutor = UseCaseExecutorImpl()
        val productDetailsUsecase = GetProductDetailsUsecase(useCaseExecutor,mainThread, detailsProductRepository)
        val bidProductUsecase = BidProductUsecase(useCaseExecutor,mainThread,bidRepository)
        presenter = DetailProductPresenter(view,productDetailsUsecase)
    }

    @Test
    fun tellScreenToShowDetails() {
        val details = DetailsProduct("1","sepeda","100","","bagus","kemarin","","","")

        Mockito.`when`(detailsProductRepository.getDetailsProduct("1")).thenReturn(details)

        presenter.getProducts("1")

        Mockito.verify(view, Mockito.timeout(100)).showDetails(productCaptor.capture())
        assert(productCaptor.firstValue==details)
    }
}