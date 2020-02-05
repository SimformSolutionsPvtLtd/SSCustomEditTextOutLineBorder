package simform.com.customedittextoutlineborder.extention

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Extension function for observing [LiveData]
 * @param owner is [LifecycleOwner] which will be used to listen lifecycle changes
 * @param func is a function which will be executed whenever [LiveData] is changed
 * */
fun <T> LiveData<T>.watch(owner: LifecycleOwner, func: (T) -> Unit) = observe(owner, Observer { value ->
    value?.let {
        func(it)
    }
})