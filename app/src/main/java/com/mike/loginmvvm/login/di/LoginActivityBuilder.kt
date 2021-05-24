package com.mike.loginmvvm.login.di

import com.mike.loginmvvm.di.ActivityScope
import com.mike.loginmvvm.login.ui.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginActivityBuilder {

    @ContributesAndroidInjector(modules = [LoginActivityModule::class, LoginViewModelModule::class])
    @ActivityScope
    abstract fun loginActivity(): LoginActivity
}