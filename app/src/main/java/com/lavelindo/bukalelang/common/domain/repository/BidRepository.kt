package com.lavelindo.bukalelang.common.domain.repository

/**
 * Created by sujarwe on 5/28/17.
 */
interface BidRepository {
    fun bidProduct(id: String, username: String, nilai: String): String
}