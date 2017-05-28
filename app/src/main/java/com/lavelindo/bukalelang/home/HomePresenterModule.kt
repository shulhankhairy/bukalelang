package com.lavelindo.bukalelang.home

import com.lavelindo.bukalelang.common.di.ApplicationApi
import com.lavelindo.bukalelang.common.di.ApplicationComponent
import com.lavelindo.bukalelang.common.di.ApplicationModule
import com.lavelindo.bukalelang.home.domain.GetProductsUseCase
import com.lavelindo.bukalelang.home.domain.ProductsRepository
import com.lavelindo.bukalelang.home.domain.ProductsRepositoryImpl
import space.traversal.kapsule.Injects

/**
 * Created by sujarwe on 5/28/17.
 */
class HomePresenterModule(val view: HomeView) : Injects<ApplicationComponent>{
    private val executor by required { executor }
    private val mainThread by required { mainThread }
    private val api by required { api }
    private var repository:ProductsRepository
    private var usecase:GetProductsUseCase
    init {
        inject(ApplicationComponent(ApplicationModule(),ApplicationApi()))
        repository=ProductsRepositoryImpl(api)
        usecase=GetProductsUseCase(executor,mainThread,repository)
    }
    val presenter get() = HomePresenter(view,usecase)
}