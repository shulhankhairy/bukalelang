package com.lavelindo.bukalelang.common.domain.executor

import android.os.Handler
import android.os.Looper


/**
 * Created by sujarwe on 5/23/17.
 */
class MainThreadImpl
constructor() : MainThread {

    private val mHandler: Handler

    init {
        mHandler = Handler(Looper.getMainLooper())
    }

    override fun post(runnables: Runnable) {
        mHandler.post(runnables)
    }

    companion object {
        private val sMainThread: MainThread? = null
    }

    /*public static MainThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new MainThreadImpl();
        }

        return sMainThread;
    }*/
}
