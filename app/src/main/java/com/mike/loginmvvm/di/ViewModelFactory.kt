package com.mike.loginmvvm.di

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(var viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return viewModels[modelClass]?.get() as T
    }
}

inline fun <reified VM : ViewModel> ViewModelProvider.Factory.obtainViewModel(activity: FragmentActivity): VM =
    ViewModelProvider(activity, this)[VM::class.java]