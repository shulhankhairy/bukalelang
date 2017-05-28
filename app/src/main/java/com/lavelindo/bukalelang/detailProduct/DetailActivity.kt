package com.lavelindo.bukalelang.detailProduct

import android.app.AlertDialog
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.lavelindo.bukalelang.R
import com.lavelindo.bukalelang.detailProduct.domain.DetailsProduct
import space.traversal.kapsule.Injects

class DetailActivity : AppCompatActivity(), DetailsProductView, Injects<DetailsPresenterModule> {

    lateinit var nama: TextView
    lateinit var harga: TextView
    lateinit var tglMulai: TextView
    lateinit var tglSelesai: TextView
    lateinit var desc: TextView
    lateinit var kelipatan: String

    val presenter by required { presenter }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val extras = intent
        val id = extras.getStringExtra("id")

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        nama = findViewById(R.id.detail_nama) as TextView
        harga = findViewById(R.id.detail_harga) as TextView
        tglMulai = findViewById(R.id.detail_tgl_mulai) as TextView
        tglSelesai = findViewById(R.id.detail_tgl_selesai) as TextView
        desc = findViewById(R.id.detail_desc) as TextView
        setSupportActionBar(toolbar)

        inject(DetailsPresenterModule(this))
        presenter.getProducts(id)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.bid_dialog,null)
            val dialogBid = AlertDialog.Builder(this).setView(view).create()
            val kelipatan = view.findViewById(R.id.detail_kelipatan) as TextView
            kelipatan.text = this.kelipatan
            val bid = view.findViewById(R.id.bid_harga) as EditText
            val bidBtn = view.findViewById(R.id.bid_btn) as Button
            bidBtn.setOnClickListener {
                presenter.bidProduct(id,"bobbykristya",bid.text.toString())
                dialogBid.dismiss()
                finish()
            }
            dialogBid.show()
        }
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun showDetails(detailsProduct: DetailsProduct) {
        nama.text = detailsProduct.nama
        harga.text = detailsProduct.harga
        tglMulai.text = detailsProduct.tglMulai
        tglSelesai.text = detailsProduct.tglSelesai
        desc.text = detailsProduct.desc
        kelipatan = detailsProduct.kelipatan
    }

}
