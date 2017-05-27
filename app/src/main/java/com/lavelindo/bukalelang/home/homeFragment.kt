package com.lavelindo.bukalelang.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.lavelindo.bukalelang.R

/**
 * Created by sujarwe on 5/24/17.
 */

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var rv_products:RecyclerView
    lateinit var progressbar:ProgressBar

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        view?.let {
            rv_products = view.findViewById(R.id.rv_products) as RecyclerView
            progressbar = view.findViewById(R.id.progressBar) as ProgressBar
        }
        return view
    }
}
