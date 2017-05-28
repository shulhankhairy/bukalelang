package com.lavelindo.bukalelang.common.api

import com.lavelindo.bukalelang.detailProduct.domain.DetailsProduct
import com.lavelindo.bukalelang.home.domain.Products
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by sujarwe on 5/26/17.
 */
interface BukalelangApi {

    @GET("get_product.php")
    fun getProducts(): Call<Products>

    @FormUrlEncoded
    @POST("get_product_detail.php")
    fun getDetails(@Query("idLelang") id: String): Call<DetailsProduct>

    @FormUrlEncoded
    @POST("insert_bid.php")
    fun bidProduct(@Query("idLelang") id: String, @Query("username") username: String, @Query("nilai") nilai: String)
}