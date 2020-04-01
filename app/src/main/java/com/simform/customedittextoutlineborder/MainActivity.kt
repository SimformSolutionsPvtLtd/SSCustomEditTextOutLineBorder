package com.simform.customedittextoutlineborder

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.simform.customedittextoutlineborder.extention.watch
import kotlinx.android.synthetic.main.activity_main.*
import shweta.com.customedittextoutlineborder.R
import shweta.com.customedittextoutlineborder.databinding.MainActivityBinding

class MainActivity : BaseActivity<MainActivityBinding, MainActivityViewModel>() {
    override val mViewModel: MainActivityViewModel
        get() = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)


    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun init() {
        bindObject.clickHandler = this
        edtEmail.setTextValue("Mahi@gmail.com")
    }

    override fun onClick(v: View?) {

    }

    override fun initializeObservers() {
        mViewModel.formValidationLiveData.watch(this) { message ->
            message.run {
                when {
                    formIsValid != 0 -> {
                        Toast.makeText(this@MainActivity, "Validation Success", Toast.LENGTH_LONG).show()
                    }
                }
            }
            bindObject.formMessage = message
        }
    }
}
