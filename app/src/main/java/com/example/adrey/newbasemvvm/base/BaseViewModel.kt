package com.example.adrey.newbasemvvm.base

import android.arch.lifecycle.ViewModel

abstract class BaseViewModel<N> : ViewModel() {

    private var mNavigator: N? = null

    fun getNavigator() = mNavigator

    fun setNavigator(navigator: N) {
        mNavigator = navigator
    }

    // Declare your variabel composite, sharedprefs, access db, other

    override fun onCleared() {
        super.onCleared()
        // Clear yout variabel compsite, other
    }
}