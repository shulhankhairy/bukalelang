package com.lavelindo.bukalelang.common.di

import com.lavelindo.bukalelang.common.api.BukalelangApi
import com.lavelindo.bukalelang.common.domain.executor.MainThread
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutor

/**
 * Created by sujarwe on 5/28/17.
 */
class ApplicationComponent(domain: Domain, api: Api) : Domain by domain, Api by api

interface Domain{
    val executor: UseCaseExecutor
    val mainThread: MainThread
}

interface Api{
    val api: BukalelangApi
}