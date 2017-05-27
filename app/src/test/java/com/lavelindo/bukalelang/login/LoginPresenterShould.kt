package com.lavelindo.bukalelang.login

import com.lavelindo.bukalelang.TestMainThread
import com.lavelindo.bukalelang.common.data.AccessToken
import com.lavelindo.bukalelang.common.domain.executor.UseCaseExecutorImpl
import com.lavelindo.bukalelang.common.domain.repository.CredentialsRepository
import com.lavelindo.bukalelang.login.domain.LoginUseCase
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


/**
 * Created by sujarwe on 5/21/17.
 */
class LoginPresenterShould {
    lateinit var loginPresenter: LoginPresenter

    val loginview = mock<Loginview>()
    val credentialsRepository = mock<CredentialsRepository>()

    @Before
    fun setUp() {
        val mainThread = TestMainThread()
        val useCaseExecutor = UseCaseExecutorImpl()
        val loginUseCase = LoginUseCase(useCaseExecutor,mainThread,credentialsRepository)
        loginPresenter = LoginPresenter(loginview,loginUseCase)
    }

    @Test
    fun showErrorIfUsernameEmpty() {
        val username = ""
        val password = ""
        loginPresenter.login(username,password)
        Thread.sleep(10)

        Mockito.verify(loginview).showToast(Mockito.anyString())
    }

    @Test
    fun showErrorIfPasswordEmpty(){
        val username = "adit"
        val password = ""

        loginPresenter.login(username,password)
        Thread.sleep(10)

        Mockito.verify(loginview).showToast(Mockito.anyString())
    }

    @Test
    fun loginSuccess(){
        val username = "adit"
        val password = "1234"

        Mockito.`when`(credentialsRepository.getAccessToken(username,password)).thenReturn(AccessToken(username,password,null))

        loginPresenter.login(username,password)
        Thread.sleep(10)

        Mockito.verify(loginview).showLoading()
        Mockito.verify(loginview).backToMainPage()
    }

    @Test
    fun loginFailed() {
        val username = "adit"
        val password = "12345"

        Mockito.`when`(credentialsRepository.getAccessToken(username, password)).thenReturn(AccessToken("","","login gagal"))

        loginPresenter.login(username,password)
        Thread.sleep(10)

        Mockito.verify(loginview).showLoading()
        Mockito.verify(loginview).showToast(Mockito.anyString())
    }

}
/*inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)
inline fun <reified T : Any> captor() = ArgumentCaptor.forClass(T::class.java)*/
