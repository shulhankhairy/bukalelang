package com.lavelindo.bukalelang.login

/**
 * Created by sujarwe on 5/23/17.
 */
 interface Loginview {
    fun showLoading()
    fun dismissLoading()
    fun showToast(message : String)
    fun backToMainPage()
    fun goToRegister()
}