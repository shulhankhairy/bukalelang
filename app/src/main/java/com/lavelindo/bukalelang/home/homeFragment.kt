package com.lavelindo.bukalelang.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.lavelindo.bukalelang.R
import com.lavelindo.bukalelang.detailProduct.DetailActivity
import com.lavelindo.bukalelang.home.domain.Product
import space.traversal.kapsule.Injects

/**
 * Created by sujarwe on 5/24/17.
 */

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), HomeView, ProductsAdapter.ProductsEventListener, Injects<HomePresenterModule> {

    lateinit var rv_products:RecyclerView
    lateinit var progressbar:ProgressBar
    val presenter by required { presenter }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        rv_products = view?.findViewById(R.id.rv_products) as RecyclerView
        val layoutManager = LinearLayoutManager(activity)
        rv_products.layoutManager = layoutManager
        progressbar = view.findViewById(R.id.progressBar) as ProgressBar
        inject(HomePresenterModule(this))
        presenter.getProducts()
        return view
    }

    override fun showLoading() {
        progressbar.visibility = View.VISIBLE
    }

    override fun dismissLoading() {
        progressbar.visibility = View.GONE
    }

    override fun goToDetailOf(product: Product) {
        val i = Intent(activity,DetailActivity::class.java)
        i.putExtra("id",product.id)
        activity.startActivity(i)
    }

    override fun showProductList(products: List<Product>) {
        val adapter = ProductsAdapter(products,this)
        rv_products.adapter = adapter
        rv_products.visibility = View.VISIBLE
    }

    override fun onClick(products: List<Product>, index: Int) {
        presenter.onItemClicked(products,index)
    }

}