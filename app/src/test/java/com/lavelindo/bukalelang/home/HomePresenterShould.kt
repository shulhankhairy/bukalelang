package com.lavelindo.bukalelang.home

import com.lavelindo.bukalelang.TestMainThread
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutorImpl
import com.lavelindo.bukalelang.home.domain.GetProductsUseCase
import com.lavelindo.bukalelang.home.domain.Product
import com.lavelindo.bukalelang.home.domain.ProductsRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.argumentCaptor
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.timeout

/**
 * Created by sujarwe on 5/24/17.
 */
class HomePresenterShould {
    lateinit var homePresenter: HomePresenter
    val homeView = mock<HomeView>()
    val productsRepository = mock<ProductsRepository>()
    val productsCaptor = argumentCaptor<List<Product>>()
    val productCaptor = argumentCaptor<Product>()

    @Before
    fun setUp() {
        val mainThread = TestMainThread()
        val useCaseExecutor = UseCaseExecutorImpl()
        val useCase = GetProductsUseCase(useCaseExecutor,mainThread, productsRepository)
        homePresenter = HomePresenter(homeView,useCase)
    }

    @Test
    fun tellScreenToShowProducts() {
        val product1 = Product("1","jupiter","100","sekarang")
        val product2 = Product("2","ps4","50","sekarang")
        val product3 = Product("3","jaket spidey","9","sekarang")
        val products = listOf(product1,product2,product3)

        Mockito.`when`(productsRepository.getProducts()).thenReturn(products)

        homePresenter.getProducts()

        Mockito.verify(homeView,timeout(100)).showLoading()
        Mockito.verify(homeView, timeout(100)).dismissLoading()
        Mockito.verify(homeView, timeout(100)).showProductList(productsCaptor.capture())
        assert(productsCaptor.firstValue==products)
    }

    @Test
    fun tellScreenToGoToDetailProduct() {
        val product1 = Product("1","jupiter","100","sekarang")
        val product2 = Product("2","ps4","50","sekarang")
        val product3 = Product("3","jaket spidey","9","sekarang")
        val products = listOf(product1,product2,product3)

        homePresenter.onItemClicked(products,0)

        Mockito.verify(homeView, timeout(100)).goToDetailOf(productCaptor.capture())
        assert(productCaptor.firstValue==product1)
    }
}