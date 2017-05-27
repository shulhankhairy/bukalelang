package com.lavelindo.bukalelang.common.domain.executor

/**
 * Created by sujarwe on 5/23/17.
 */
interface MainThread {
    fun post(runnables: Runnable)
}