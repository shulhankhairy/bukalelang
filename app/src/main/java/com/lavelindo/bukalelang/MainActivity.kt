package com.lavelindo.bukalelang

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.MenuItem

import com.lavelindo.bukalelang.R
import com.lavelindo.bukalelang.home.HomeFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomView = findViewById(R.id.navigation) as BottomNavigationView
        bottomView.setOnNavigationItemSelectedListener {
            var selectedFragment: Fragment? = null
            when(it.itemId)
            {
                R.id.nav_home -> selectedFragment = HomeFragment()
                else -> {
                    println("now")
                }
            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, selectedFragment).commit()
            true
        }
        bottomView.setSelectedItemId(R.id.nav_home)
    }
}
