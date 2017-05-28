package com.lavelindo.bukalelang.detailProduct

import com.lavelindo.bukalelang.detailProduct.domain.DetailsProduct
import com.lavelindo.bukalelang.detailProduct.domain.DetailsProductRepository
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock

/**
 * Created by sujarwe on 5/27/17.
 */
class DetailProductPresenterShould {
    lateinit var presenter: DetailProductPresenter
    val view = mock<DetailsProductView>()
    val productsRepository = mock<DetailsProductRepository>()
    val productsCaptor = argumentCaptor<List<DetailsProduct>>()
    val productCaptor = argumentCaptor<DetailsProduct>()
}