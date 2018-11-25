package com.example.adrey.newbasemvvm.ui

import android.os.Bundle
import android.widget.Toast
import com.example.adrey.newbasemvvm.BR
import com.example.adrey.newbasemvvm.R
import com.example.adrey.newbasemvvm.base.BaseActivity
import com.example.adrey.newbasemvvm.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    private var activityMainBinding: ActivityMainBinding? = null
    private val mainViewModel = MainViewModel()

    override fun getBindingVariable(): Int = BR.main

    override fun getViewModel(): MainViewModel = mainViewModel

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.setNavigator(this)
        activityMainBinding = getViewDataBinding()
    }

    override fun login() {
        val username = ed_username.text.toString()
        val password = ed_password.text.toString()
        if (mainViewModel.ifUsenamePasswordValid(username, password))
            mainViewModel.onLogin(username, password)
    }

    override fun setUsernameError() {
        ed_username.error = "Username not valid"
    }

    override fun setPasswordError() {
        ed_password.error = "Password not valid"
    }

    override fun showErrorLogin() {
        Toast.makeText(this, "Username and Password not same", Toast.LENGTH_SHORT).show()
    }

    override fun showHomeActivity() {
        Toast.makeText(this, "Show Home Activity", Toast.LENGTH_SHORT).show()
    }
}
