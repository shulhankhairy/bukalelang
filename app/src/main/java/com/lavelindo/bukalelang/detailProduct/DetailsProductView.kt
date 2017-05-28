package com.lavelindo.bukalelang.detailProduct

import com.lavelindo.bukalelang.detailProduct.domain.DetailsProduct

/**
 * Created by sujarwe on 5/27/17.
 */
interface DetailsProductView {
    fun showLoading()
    fun dismissLoading()
    fun showDetails(detailsProduct: DetailsProduct)
    fun showMessage(msg: String)
}