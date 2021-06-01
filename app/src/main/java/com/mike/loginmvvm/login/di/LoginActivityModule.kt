package com.mike.loginmvvm.login.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mike.loginmvvm.di.ActivityScope
import com.mike.loginmvvm.di.ViewModelFactory
import com.mike.loginmvvm.login.model.LoginUseCase
import com.mike.loginmvvm.login.model.LoginUseCaseImpl
import com.mike.loginmvvm.login.repo.LoginRepo
import com.mike.loginmvvm.login.repo.LoginRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class LoginActivityModule {

    @Provides
    @ActivityScope
    fun provideLoginRepo(loginRepoImpl: LoginRepoImpl): LoginRepo {
        return loginRepoImpl
    }

    @Provides
    @ActivityScope
    fun provideLoginUseCase(loginUseCaseImpl: LoginUseCaseImpl): LoginUseCase {
        return loginUseCaseImpl
    }
    
    @Provides
    @ActivityScope
    fun provideFactory(viewModels:MutableMap<Class<out ViewModel>, Provider<ViewModel>>): ViewModelProvider.Factory {
        return ViewModelFactory(viewModels)
    }
}
