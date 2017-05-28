package com.lavelindo.bukalelang.common.domain.executor

import com.lavelindo.bukalelang.common.domain.usecase.AbstractUseCase
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


/**
 * Created by sujarwe on 5/23/17.
 */
class UseCaseExecutorImpl
constructor() : UseCaseExecutor {

    private val mThreadPoolExecutor: ThreadPoolExecutor

    init {
        val keepAlive = KEEP_ALIVE_TIME.toLong()
        mThreadPoolExecutor = ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                keepAlive,
                TIME_UNIT,
                WORK_QUEUE)
    }

    override fun execute(interactor: AbstractUseCase<*, *>) {
        mThreadPoolExecutor.submit {interactor.run()}
    }

    companion object {
        @Volatile private var sThreadExecutor: UseCaseExecutor? = null

        private val CORE_POOL_SIZE = 3
        private val MAX_POOL_SIZE = 5
        private val KEEP_ALIVE_TIME = 120
        private val TIME_UNIT = TimeUnit.SECONDS
        private val WORK_QUEUE = LinkedBlockingQueue<Runnable>()
    }

    /**
     * Returns a singleton instance of this executor. If the executor is not initialized then it initializes it and returns
     * the instance.
     */
    /*public static UseCaseExecutor getInstance() {
        if (sThreadExecutor == null) {
            sThreadExecutor = new UseCaseExecutorImpl();
        }

        return sThreadExecutor;
    }*/
}
