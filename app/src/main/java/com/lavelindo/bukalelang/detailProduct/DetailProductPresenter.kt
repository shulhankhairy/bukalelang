package com.lavelindo.bukalelang.detailProduct

import android.util.Log
import com.lavelindo.bukalelang.common.domain.usecase.AbstractUseCase
import com.lavelindo.bukalelang.detailProduct.domain.BidProductUsecase
import com.lavelindo.bukalelang.detailProduct.domain.GetProductDetailsUsecase

/**
 * Created by sujarwe on 5/27/17.
 */
class DetailProductPresenter
(val view: DetailsProductView,
 val productDetailsUsecase: GetProductDetailsUsecase,
 val bidProductUsecase: BidProductUsecase) {

    val callback = object : AbstractUseCase.Callback<GetProductDetailsUsecase.Response> {
        override fun onSuccess(response: GetProductDetailsUsecase.Response) {
            view.showDetails(response.detailsProduct)
        }
    }

    val bidCallback = object : AbstractUseCase.Callback<BidProductUsecase.Response>
    {
        override fun onSuccess(response: BidProductUsecase.Response) {
            view.showMessage(response.status)
        }
    }

    fun bidProduct(id: String, name: String, nilai: String)
    {
        bidProductUsecase.execute(BidProductUsecase.Params(id,name,nilai),bidCallback)
    }

    fun getProducts(id: String)
    {
        //view.showLoading()
        productDetailsUsecase.execute(GetProductDetailsUsecase.Param(id),callback)
    }

}