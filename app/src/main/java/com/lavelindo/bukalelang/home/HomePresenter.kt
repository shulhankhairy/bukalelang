package com.lavelindo.bukalelang.home

import com.lavelindo.bukalelang.common.domain.usecase.AbstractUseCase
import com.lavelindo.bukalelang.home.domain.GetProductsUseCase
import com.lavelindo.bukalelang.home.domain.Product

/**
 * Created by sujarwe on 5/24/17.
 */
class HomePresenter(val homeView: HomeView, val getProductsUseCase: GetProductsUseCase)
{
    val callback = object : AbstractUseCase.Callback<GetProductsUseCase.Response> {
        override fun onSuccess(response: GetProductsUseCase.Response) {
            homeView.dismissLoading()
            homeView.showProductList(response.products)
        }
    }
    
    fun getProducts()
    {
        homeView.showLoading()
        getProductsUseCase.execute(Unit,callback)
    }

    fun onItemClicked(items: List<Product>, index: Int)
    {
        val product = items[index]
        homeView.goToDetailOf(product)
    }
}