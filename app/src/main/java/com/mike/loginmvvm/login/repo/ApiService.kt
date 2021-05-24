package com.mike.loginmvvm.login.repo

import com.mike.loginmvvm.login.entity.UseInfo
import io.reactivex.Single
import retrofit2.http.POST

interface ApiService {
    @POST("/api/login")
    fun login(): Single<UseInfo>
}