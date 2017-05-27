package com.lavelindo.bukalelang.common.domain.usecase

import com.lavelindo.bukalelang.common.domain.executor.MainThread
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutor



/**
 * Created by sujarwe on 5/23/17.
 */
abstract class AbstractUseCase<P, R>(private val mThreadExecutor: UseCaseExecutor, protected var mMainThread: MainThread) {

    protected var callback: Callback<R>? = null
    private var params: P? = null

    fun run() {
        run(params)
    }

    abstract fun run(params: P?)

    fun execute(params: P, callback: Callback<R>) {
        // start running this interactor in a background thread
        this.params = params
        this.callback = callback
        mThreadExecutor.execute(this)
    }

    interface Callback<R> {
        fun onSuccess(response: R)
    }
}
