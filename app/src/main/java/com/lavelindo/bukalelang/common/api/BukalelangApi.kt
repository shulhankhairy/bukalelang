package com.lavelindo.bukalelang.common.api

import com.lavelindo.bukalelang.home.domain.Products
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by sujarwe on 5/26/17.
 */
interface BukalelangApi {

    @GET("get_product.php")
    fun getProducts(): Call<Products>
}