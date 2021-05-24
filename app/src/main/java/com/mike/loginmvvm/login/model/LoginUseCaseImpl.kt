package com.mike.loginmvvm.login.model

import com.mike.loginmvvm.login.entity.UseInfo
import com.mike.loginmvvm.login.repo.LoginRepo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(private val loginRepo: LoginRepo) : LoginUseCase {

    override fun login(): Single<UseInfo> {
        return loginRepo.login()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}