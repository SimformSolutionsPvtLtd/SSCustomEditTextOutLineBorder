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
package com.simform.customedittextoutlineborder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Splash ActivityViewModel
 */
class SplashActivityViewModel : ViewModel() {
    val mutableLiveData = MutableLiveData<SplashState>()
    private val splashScreenDelay: Long = 3000

    init {
        viewModelScope.launch {
            delay(splashScreenDelay)
            mutableLiveData.postValue(SplashState.MainActivity)
        }
    }

    /**
     * This class is used to show splash state.
     */
    sealed class SplashState {
        /**
         * This object is used to navigate splash screen to main activity.
         */
        object MainActivity : SplashState()
    }
}
