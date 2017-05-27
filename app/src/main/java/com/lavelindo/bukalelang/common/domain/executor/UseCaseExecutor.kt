package com.lavelindo.bukalelang.common.domain.executor

import com.lavelindo.bukalelang.common.domain.usecase.AbstractUseCase

/**
 * Created by sujarwe on 5/23/17.
 */
interface UseCaseExecutor {
    fun execute(interactor: AbstractUseCase<*, *>)
}
