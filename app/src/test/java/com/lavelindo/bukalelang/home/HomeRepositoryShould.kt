package com.lavelindo.bukalelang.home

import com.lavelindo.bukalelang.common.api.BukalelangApi
import com.lavelindo.bukalelang.home.domain.Product
import com.lavelindo.bukalelang.home.domain.ProductsRepositoryImpl
import com.nhaarman.mockito_kotlin.mock
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Call
import retrofit2.Response

/**
 * Created by sujarwe on 5/26/17.
 */
class HomeRepositoryShould {
    lateinit var productsRepository: ProductsRepositoryImpl
    val bukalelangApi = mock<BukalelangApi>()
    val call = mock<Call<List<Product>>>()

    @Before
    fun setUp() {
        productsRepository = ProductsRepositoryImpl(bukalelangApi)
    }

    @Test
    fun showProducts() {
        val product1 = Product("1","sepda","rp 100","sekarang")
        val product2 = Product("2","laptop","rp 60","sekarang")
        val product3 = Product("3","mobil","rp 200","sekarang")
        val products = listOf(product1,product2,product3)

        Mockito.`when`(call.execute()).thenReturn(Response.success(products))
        Mockito.`when`(bukalelangApi.getProducts()).thenReturn(call)

        assert(productsRepository.getProducts()==products)
    }

    @Test
    fun handleFailure() {
        Mockito.`when`(call.execute()).thenReturn(Response.error(500, ResponseBody.create(null,"server Error")))
        Mockito.`when`(bukalelangApi.getProducts()).thenReturn(call)

        assert(productsRepository.getProducts()== listOf<Product>())
    }
}