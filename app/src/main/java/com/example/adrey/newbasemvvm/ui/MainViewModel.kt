package com.example.adrey.newbasemvvm.ui

import android.databinding.ObservableBoolean
import android.os.Handler
import android.text.TextUtils
import com.example.adrey.newbasemvvm.base.BaseViewModel

class MainViewModel : BaseViewModel<MainNavigator>() {

    var mIsLoading = ObservableBoolean(false)

    fun ifUsenamePasswordValid(username: String, password: String) : Boolean {
        if (TextUtils.isEmpty(username)) {
            getNavigator()?.setUsernameError()
            return false
        }
        if (TextUtils.isEmpty(password)) {
            getNavigator()?.setPasswordError()
            return false
        }
        return true
    }

    fun login() {
        getNavigator()?.login()
    }

    fun onLogin(username: String, password: String) {
        setIsLoading(true)
        if (username == password)
            Handler().postDelayed({
                getNavigator()?.showHomeActivity()
                setIsLoading(false)
            }, 2000)
        else
            Handler().postDelayed({
                getNavigator()?.showErrorLogin()
                setIsLoading(false)
            }, 2000)
    }

    private fun setIsLoading(loading: Boolean) {
        mIsLoading.set(loading)
    }

//    fun isLoading() : ObservableBoolean = mIsLoading
}