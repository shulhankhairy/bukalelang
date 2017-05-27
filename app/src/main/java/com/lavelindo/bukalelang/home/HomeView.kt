package com.lavelindo.bukalelang.home

import com.lavelindo.bukalelang.home.domain.Product

/**
 * Created by sujarwe on 5/24/17.
 */
interface HomeView {
    fun showLoading()
    fun dismissLoading()
    fun goToDetailOf(product: Product)
    fun showProductList(products: List<Product>)
}