package com.lavelindo.bukalelang.home.domain

/**
 * Created by sujarwe on 5/24/17.
 */
interface ProductsRepository {
    fun getProducts():List<Product>
}