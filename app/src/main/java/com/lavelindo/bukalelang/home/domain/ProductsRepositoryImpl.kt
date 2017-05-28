package com.lavelindo.bukalelang.home.domain

import android.util.Log
import com.lavelindo.bukalelang.common.api.BukalelangApi

/**
 * Created by sujarwe on 5/26/17.
 */
class ProductsRepositoryImpl(val bukalelangApi: BukalelangApi) : ProductsRepository {
    override fun getProducts(): List<Product> {
        val call = bukalelangApi.getProducts()
        val response = call.execute()
        when(response.code())
        {
            200 -> return response.body()?.listProduk ?: emptyList()
            else -> return emptyList()
        }
    }
}