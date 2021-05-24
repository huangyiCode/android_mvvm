package com.mike.loginmvvm.login.repo

import com.mike.loginmvvm.login.entity.UseInfo
import io.reactivex.Single

interface LoginRepo {
    fun login(): Single<UseInfo>
}