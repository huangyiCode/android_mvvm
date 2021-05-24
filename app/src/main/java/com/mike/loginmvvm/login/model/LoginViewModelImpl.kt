package com.mike.loginmvvm.login.model

import androidx.lifecycle.MutableLiveData
import com.mike.loginmvvm.login.entity.UseInfo
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginViewModelImpl @Inject constructor(override val useCase: LoginUseCase) :
    LoginViewModel() {

    override val showProgress: MutableLiveData<Boolean> = MutableLiveData(false)

    override val userInfo: MutableLiveData<UseInfo> = MutableLiveData()

    private val compositeDisposable = CompositeDisposable()

    override fun login() {
        showProgress.postValue(true)
        useCase.login()
            .doAfterTerminate {
                showProgress.postValue(false)
            }
            .subscribe({
                userInfo.value = it
            }, {
                //TODO Error
            }).also {
                compositeDisposable.add(it)
            }
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}