package com.lavelindo.bukalelang.detailProduct

import android.app.AlertDialog
import android.app.DialogFragment
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.lavelindo.bukalelang.R
import java.util.zip.Inflater

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.bid_dialog,null)
            val dialogBid = AlertDialog.Builder(this).setView(view).create()
            val kelipatan = findViewById(R.id.detail_kelipatan) as TextView
            val bid = findViewById(R.id.bid_harga) as EditText
            val bidBtn = findViewById(R.id.bid_btn) as Button
        }
    }

}
