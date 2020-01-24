/**
 * Copyright 2019 PoolTrader
 * Develop By Shweta Chauhan
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package shweta.com.customedittextoutlineborder

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * This is base activity of all activities
 */
abstract class BaseActivity<Binding : ViewDataBinding, ViewModel : MainActivityViewModel> : AppCompatActivity(), View.OnClickListener {

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