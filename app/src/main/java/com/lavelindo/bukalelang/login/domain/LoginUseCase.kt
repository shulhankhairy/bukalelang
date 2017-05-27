package com.lavelindo.bukalelang.login.domain

import com.lavelindo.bukalelang.common.domain.executor.MainThread
import com.lavelindo.bukalelang.common.domain.repository.CredentialsRepository
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutor
import com.lavelindo.bukalelang.common.domain.usecase.AbstractUseCase


/**
 * Created by sujarwe on 5/23/17.
 */
class LoginUseCase
(threadExecutor: UseCaseExecutor, mainThread: MainThread, private val repository: CredentialsRepository) :
        AbstractUseCase<LoginUseCase.Params, LoginUseCase.Response>(threadExecutor, mainThread) {

    override fun run(params: Params?) {
        val username = params?.username ?: ""
        val password = params?.password ?: ""
        val token = repository.getAccessToken(username, password)
        mMainThread.post(
                Runnable {
                   callback?.onSuccess(Response(token.message))
                }
        )
    }

    data class Params(val username: String, val password: String)
    data class Response(var message: String?)
}
