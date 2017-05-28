package com.lavelindo.bukalelang.detailProduct.domain

/**
 * Created by sujarwe on 5/27/17.
 */
interface DetailsProductRepository {
    fun getDetailsProduct(id: String): DetailsProduct
}