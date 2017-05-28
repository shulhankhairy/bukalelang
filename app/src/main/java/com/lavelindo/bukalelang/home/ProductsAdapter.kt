package com.lavelindo.bukalelang.home

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lavelindo.bukalelang.R
import com.lavelindo.bukalelang.home.domain.Product

/**
 * Created by sujarwe on 5/27/17.
 */
class ProductsAdapter(var productList: List<Product>, var listener: ProductsEventListener) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_products,parent,false)
        val holder = ProductViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProductViewHolder?, position: Int) {
        holder?.title?.setText(productList[position].nama)
        holder?.price?.setText(productList[position].harga)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    interface ProductsEventListener
    {
        fun onClick(products: List<Product>,index: Int)
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val cv = itemView.findViewById(R.id.container) as ConstraintLayout
        /*val image: ImageView by lazy { itemView?.findViewById(R.id.image) as ImageView }*/
        val title: TextView = itemView.findViewById(R.id.title) as TextView
        /*val time: TextView by lazy { itemView?.findViewById(R.id.time) as TextView }*/
        val price: TextView = itemView.findViewById(R.id.price) as TextView

        init {
            cv.setOnClickListener {
                listener.onClick(productList,adapterPosition)
            }
        }
    }
}