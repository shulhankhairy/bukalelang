package com.lavelindo.bukalelang.home.domain

/**
 * Created by sujarwe on 5/24/17.
 */
data class Products(val listProduk: List<Product>)
data class Product(val id: String, val nama: String, val harga: String, val tglSelesai: String)