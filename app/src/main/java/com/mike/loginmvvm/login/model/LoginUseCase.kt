package com.mike.loginmvvm.login.model

import com.mike.loginmvvm.login.entity.UseInfo
import io.reactivex.Single

interface LoginUseCase {
    fun login(): Single<UseInfo>
}