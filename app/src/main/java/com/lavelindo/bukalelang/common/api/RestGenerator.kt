package com.lavelindo.bukalelang.common.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


/**
 * Created by sujarwe on 5/26/17.
 */
class RestGenerator {
    companion object {
        private val WEBSERVICE_URL = "http://acacaa.com/bukalelang/"

        private lateinit var builder: Retrofit.Builder

        private val httpClient = OkHttpClient.Builder()
        private val logging = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        fun <S> createService(serviceClass: Class<S>): S {
            httpClient.addInterceptor(logging)
            builder = Retrofit.Builder()
                    .client(httpClient.build())
                    .addConverterFactory(MoshiConverterFactory.create())
            builder.baseUrl(WEBSERVICE_URL)
            val restAdapter = builder.build()
            return restAdapter.create(serviceClass)
        }
    }

}