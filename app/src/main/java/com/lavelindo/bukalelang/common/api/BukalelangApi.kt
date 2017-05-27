package com.lavelindo.bukalelang.common.api

import com.lavelindo.bukalelang.home.domain.Product
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.Call


/**
 * Created by sujarwe on 5/26/17.
 */
interface BukalelangApi {

    @FormUrlEncoded
    @POST("/getProducts")
    fun getProducts(): Call<List<Product>>
}