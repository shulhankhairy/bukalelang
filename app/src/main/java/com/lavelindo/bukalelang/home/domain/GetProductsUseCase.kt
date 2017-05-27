package com.lavelindo.bukalelang.home.domain

import com.lavelindo.bukalelang.common.domain.executor.MainThread
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutor
import com.lavelindo.bukalelang.common.domain.usecase.AbstractUseCase

/**
 * Created by sujarwe on 5/24/17.
 */
class GetProductsUseCase
(threadExecutor: UseCaseExecutor, mainThread: MainThread, private val repository: ProductsRepository) :
        AbstractUseCase<Unit, GetProductsUseCase.Response>(threadExecutor, mainThread)
{
    override fun run(params: Unit?) {
        val products = repository.getProducts()
        mMainThread.post(
                Runnable{
                    callback?.onSuccess(Response(products))
                }
        )
    }

    data class Response(var products: List<Product>)
}