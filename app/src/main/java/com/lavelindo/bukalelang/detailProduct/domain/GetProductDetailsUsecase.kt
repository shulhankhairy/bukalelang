package com.lavelindo.bukalelang.detailProduct.domain

import android.util.Log
import com.lavelindo.bukalelang.common.domain.executor.MainThread
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutor
import com.lavelindo.bukalelang.common.domain.usecase.AbstractUseCase

/**
 * Created by sujarwe on 5/28/17.
 */
class GetProductDetailsUsecase
(val executor: UseCaseExecutor, val mainThread: MainThread, val repository: DetailsProductRepository) :
        AbstractUseCase<GetProductDetailsUsecase.Param, GetProductDetailsUsecase.Response>(executor, mainThread)
{
    override fun run(params: Param?) {
        val details = repository.getDetailsProduct(params?.id ?: "")
        mMainThread.post(
                Runnable {
                    callback?.onSuccess(Response(details))
                }
        )
    }

    data class Param(var id: String)
    data class Response(var detailsProduct: DetailsProduct)
}