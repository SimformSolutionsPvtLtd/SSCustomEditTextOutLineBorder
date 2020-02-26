package com.simform.customedittextoutlineborder

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import shweta.com.customedittextoutlineborder.R
import shweta.com.customedittextoutlineborder.databinding.SplashActivityBinding
import timber.log.Timber

class SplashActivity : BaseActivity<SplashActivityBinding, SplashActivityViewModel>() {

    override val mViewModel: SplashActivityViewModel
        get() = ViewModelProviders.of(this).get(SplashActivityViewModel::class.java)

    override fun getLayoutResId(): Int = R.layout.activity_splash

    override fun init() {

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = Color.TRANSPARENT
    }

    override fun initializeObservers() {
        mViewModel.mutableLiveData.observe(this, Observer {
            when (it) {
                is SplashActivityViewModel.SplashState.MainActivity -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        })
    }


    override fun onClick(v: View?) {
        Timber.e("init")
    }
}
