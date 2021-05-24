package com.mike.loginmvvm.login.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mike.loginmvvm.R
import com.mike.loginmvvm.di.obtainViewModel
import com.mike.loginmvvm.login.model.LoginViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.atctivity_login)
        loginViewModel = viewModelFactory.obtainViewModel(this)
        loginViewModel.userInfo.observe(this, Observer {
            Toast.makeText(this, "Login complete!", Toast.LENGTH_LONG).show()
        })
        val progress = findViewById<ProgressBar>(R.id.loading)
        loginViewModel.showProgress.observe(this, Observer {
            progress.visibility = if (it) View.VISIBLE else View.INVISIBLE
        })


        findViewById<Button>(R.id.btn_login).setOnClickListener {
            loginViewModel.login()
        }
    }
}