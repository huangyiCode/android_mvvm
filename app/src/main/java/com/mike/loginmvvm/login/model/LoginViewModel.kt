package com.mike.loginmvvm.login.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mike.loginmvvm.login.entity.UseInfo

abstract class LoginViewModel : ViewModel() {
    abstract val useCase: LoginUseCase
    abstract val showProgress: MutableLiveData<Boolean>
    abstract val userInfo: MutableLiveData<UseInfo>
    abstract fun login()
}