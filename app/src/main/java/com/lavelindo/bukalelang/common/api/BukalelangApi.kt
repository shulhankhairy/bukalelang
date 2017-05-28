package com.lavelindo.bukalelang.common.api

import com.lavelindo.bukalelang.detailProduct.domain.DetailsProduct
import com.lavelindo.bukalelang.home.domain.Products
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by sujarwe on 5/26/17.
 */
interface BukalelangApi {

    @GET("get_product.php")
    fun getProducts(): Call<Products>

    @FormUrlEncoded
    @POST("get_product_detail.php")
    fun getDetails(@Field("idLelang") idLelang: String): Call<DetailsProduct>

    @FormUrlEncoded
    @POST("insert_bid.php")
    fun bidProduct(@Field("idLelang") id: String,
                   @Field("username") username: String,
                   @Field("nilai") nilai: String): Call<ResponseBody>
}