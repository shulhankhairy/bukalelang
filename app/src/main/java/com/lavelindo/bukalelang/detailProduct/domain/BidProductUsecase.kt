package com.lavelindo.bukalelang.detailProduct.domain

import com.lavelindo.bukalelang.common.domain.executor.MainThread
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutor
import com.lavelindo.bukalelang.common.domain.repository.BidRepository
import com.lavelindo.bukalelang.common.domain.usecase.AbstractUseCase

/**
 * Created by sujarwe on 5/28/17.
 */
class BidProductUsecase
(val executor: UseCaseExecutor, val mainThread: MainThread, val repository: BidRepository) :
AbstractUseCase<BidProductUsecase.Params,BidProductUsecase.Response>(executor,mainThread)
{
    override fun run(params: Params?) {
        val id = params?.id ?: ""
        val user = params?.username ?: ""
        val nilai = params?.nilai ?: ""
        val status = repository.bidProduct(id,user,nilai)
        mMainThread.post(
                Runnable {
                    callback?.onSuccess(Response(status))
                }
        )
    }


    data class Params(val id: String, val username: String, val nilai: String)
    data class Response(val status: String)
}