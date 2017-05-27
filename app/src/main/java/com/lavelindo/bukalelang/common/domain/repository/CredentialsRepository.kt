package com.lavelindo.bukalelang.common.domain.repository

import com.lavelindo.bukalelang.common.data.AccessToken

/**
 * Created by sujarwe on 5/21/17.
 */
interface CredentialsRepository {
    fun getAccessToken(username: String, password: String):AccessToken
}