package com.lavelindo.bukalelang.detailProduct

import com.lavelindo.bukalelang.common.domain.usecase.AbstractUseCase
import com.lavelindo.bukalelang.detailProduct.domain.GetProductDetailsUsecase

/**
 * Created by sujarwe on 5/27/17.
 */
class DetailProductPresenter
(val view: DetailsProductView,
 val productDetailsUsecase: GetProductDetailsUsecase) {

    val callback = object : AbstractUseCase.Callback<GetProductDetailsUsecase.Response> {
        override fun onSuccess(response: GetProductDetailsUsecase.Response) {
            view.dismissLoading()
            view.showDetails(response.detailsProduct)
        }
    }

    fun getProducts(id: String)
    {
        view.showLoading()
        productDetailsUsecase.execute(GetProductDetailsUsecase.Param(id),callback)
    }

}