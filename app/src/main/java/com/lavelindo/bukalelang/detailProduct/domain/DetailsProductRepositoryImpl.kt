package com.lavelindo.bukalelang.detailProduct.domain

import android.util.Log
import com.lavelindo.bukalelang.common.api.BukalelangApi

/**
 * Created by sujarwe on 5/28/17.
 */
class DetailsProductRepositoryImpl(var api: BukalelangApi): DetailsProductRepository {

    override fun getDetailsProduct(id: String): DetailsProduct {
        val call = api.getDetails(id)
        val response = call.execute()
        when(response.code())
        {
            200 -> return response.body() ?: DetailsProduct("0","","","","","","","","")
            else -> return DetailsProduct("","","","","","","","","")
        }
    }
}