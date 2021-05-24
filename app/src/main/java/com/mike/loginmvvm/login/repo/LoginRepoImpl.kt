package com.mike.loginmvvm.login.repo

import com.mike.loginmvvm.login.entity.UseInfo
import io.reactivex.Single
import javax.inject.Inject

class LoginRepoImpl @Inject constructor(private val apiService: ApiService) : LoginRepo {

    override fun login(): Single<UseInfo> {
//        return Single.create {
//            Thread.sleep(3000)
//            it.onSuccess(UseInfo("Mike"))
//        }
        return apiService.login()
    }
}