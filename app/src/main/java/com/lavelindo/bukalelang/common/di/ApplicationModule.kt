package com.lavelindo.bukalelang.common.di

import com.lavelindo.bukalelang.common.api.BukalelangApi
import com.lavelindo.bukalelang.common.api.RestGenerator
import com.lavelindo.bukalelang.common.domain.executor.MainThread
import com.lavelindo.bukalelang.common.domain.executor.MainThreadImpl
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutor
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutorImpl

/**
 * Created by sujarwe on 5/28/17.
 */
class ApplicationModule : Domain
{
    override val executor: UseCaseExecutor
        get() = UseCaseExecutorImpl()
    override val mainThread: MainThread
        get() = MainThreadImpl()
}
class ApplicationApi : Api {
    override val api: BukalelangApi
        get() = RestGenerator.createService(BukalelangApi::class.java)
}