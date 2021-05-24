package com.mike.loginmvvm.login.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mike.loginmvvm.di.ViewModelFactory
import com.mike.loginmvvm.di.ViewModelKey
import com.mike.loginmvvm.login.model.LoginViewModel
import com.mike.loginmvvm.login.model.LoginViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginViewModel(viewModel: LoginViewModelImpl): ViewModel
}