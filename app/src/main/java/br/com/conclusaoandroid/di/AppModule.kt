package br.com.conclusaoandroid.di

import br.com.conclusaoandroid.data.RepositoryImp
import br.com.conclusaoandroid.domain.model.UseCaseLogin
import br.com.conclusaoandroid.domain.model.UseCaseRegister
import br.com.conclusaoandroid.ui.viewModel.LoginViewModel
import br.com.conclusaoandroid.ui.viewModel.LoginViewModelImp
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { RepositoryImp() }
    factory { UseCaseRegister(get()) }
    factory { UseCaseLogin(get()) }
    viewModel<LoginViewModel> { LoginViewModelImp(get(),get()) }

}
