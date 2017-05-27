package com.lavelindo.bukalelang.login

import com.lavelindo.bukalelang.common.domain.usecase.AbstractUseCase
import com.lavelindo.bukalelang.login.domain.LoginUseCase


/**
 * Created by sujarwe on 5/21/17.
 */
class LoginPresenter(val loginView: Loginview, val loginUseCase: LoginUseCase) {

    val callback = object : AbstractUseCase.Callback<LoginUseCase.Response> {
        override fun onSuccess(response: LoginUseCase.Response) {
            val message = response.message ?: ""
            loginView.showToast(message)
            loginView.dismissLoading()
            loginView.backToMainPage()
        }
    }


    fun  login(username: String, password: String){
        if (username.isBlank())
            loginView.showToast("Username Kosong")
        else if (password.isBlank())
            loginView.showToast("Password Kosong")
        else
        {
            loginView.showLoading()
            loginUseCase.execute(LoginUseCase.Params(username, password),callback)
        }
    }
}