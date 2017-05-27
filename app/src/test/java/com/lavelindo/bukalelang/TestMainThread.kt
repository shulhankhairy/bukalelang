package com.lavelindo.bukalelang

import com.lavelindo.bukalelang.common.domain.executor.MainThread

/**
 * Created by sujarwe on 5/23/17.
 */
class TestMainThread : MainThread {
    override fun post(runnables: Runnable) {
        runnables.run()
    }

}