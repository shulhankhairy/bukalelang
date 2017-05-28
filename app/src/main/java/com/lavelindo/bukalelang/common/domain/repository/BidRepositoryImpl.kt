package com.lavelindo.bukalelang.common.domain.repository

import com.lavelindo.bukalelang.common.api.BukalelangApi

/**
 * Created by sujarwe on 5/28/17.
 */
class BidRepositoryImpl(val api: BukalelangApi) : BidRepository {
    override fun bidProduct(id: String, username: String, nilai: String): String {
        val call = api.bidProduct(id,username,nilai)
        val response = call.execute()
        when(response.code())
        {
            200 -> return "berhasil"
            else -> return "gagal"
        }
    }

}