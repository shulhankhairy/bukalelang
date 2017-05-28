package com.lavelindo.bukalelang.detailProduct.domain

/**
 * Created by sujarwe on 5/27/17.
 */
data class DetailsProduct(
        val id: String,
        val nama: String,
        val harga: String,
        val foto: String,
        val desc: String,
        val tglSelesai: String,
        val tglMulai: String,
        val kelipatan: String,
        val username: String)