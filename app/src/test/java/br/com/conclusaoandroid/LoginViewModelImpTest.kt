package br.com.conclusaoandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import br.com.conclusaoandroid.domain.model.UseCaseLogin
import br.com.conclusaoandroid.domain.model.UseCaseRegister
import br.com.conclusaoandroid.ui.viewModel.LoginViewModelImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class LoginViewModelImpTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    lateinit var useCaseLogin: UseCaseLogin

    @Mock
    lateinit var useCaseRegister: UseCaseRegister

    private lateinit var viewModel: LoginViewModelImp

    @Mock
    lateinit var loginStatusObserver: Observer<Boolean>

    @Mock
    lateinit var registerStatusObserver: Observer<Boolean>

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        viewModel = LoginViewModelImp(useCaseLogin, useCaseRegister)
        viewModel.loginStatus.observeForever(loginStatusObserver)
        viewModel.registerStatus.observeForever(registerStatusObserver)
    }

    @Test
    fun testLoginFirebase() = runBlocking {
        val email = "email@test.com"
        val password = "password"
        val expectedResult = true

        Mockito.`when`(useCaseLogin.loginFirebase(email, password)).thenReturn(expectedResult)
        viewModel.loginFirebase(email, password)

        Mockito.verify(loginStatusObserver).onChanged(expectedResult)
    }

    @Test
    fun testRegisterFirebase() = runBlocking {
        val email = "email@test.com"
        val password = "password"
        val expectedResult = true

        Mockito.`when`(useCaseRegister.registerFirebase(email, password)).thenReturn(expectedResult)
        viewModel.registerFirebase(email, password)

        Mockito.verify(registerStatusObserver).onChanged(expectedResult)
    }


}
