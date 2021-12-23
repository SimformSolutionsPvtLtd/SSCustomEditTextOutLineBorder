package com.simform.customedittextoutlineborder

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.simform.customcomponent.BR

/**
 * This is base activity of all activities
 */
abstract class BaseActivity<Binding : ViewDataBinding, ViewModel : androidx.lifecycle.ViewModel> : AppCompatActivity(), View.OnClickListener {

    protected lateinit var bindObject: Binding
    protected abstract val mViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performViewModelBinding()
        initializeObservers()
    }

    /**
     * This function is used to get layout resource id for all the screens.
     */
    @LayoutRes
    abstract fun getLayoutResId(): Int

    /**
     * This function is used to call on create method in all activities.
     */
    abstract fun init()

    /**
     * This function is used to initialize observers.
     */
    open fun initializeObservers() {
    }

    private fun performViewModelBinding() {
        bindObject = DataBindingUtil.setContentView(this, getLayoutResId())
        bindObject.setLifecycleOwner(this)
        bindObject.setVariable(BR.viewModel, mViewModel)
        bindObject.executePendingBindings()
        init()
    }
}