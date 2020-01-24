package shweta.com.customedittextoutlineborder

import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import shweta.com.customedittextoutlineborder.extention.isValidEmail
import shweta.com.customedittextoutlineborder.extention.isValidPasswordLength

class MainActivityViewModel : ViewModel() {

    var email: String = ""
    var password: String = ""

    fun onLoginButtonClick(view: View) {
        if (isFormValid()) {
            Toast.makeText(view.context, "Login Success", Toast.LENGTH_LONG).show()
        }
    }

    private fun isFormValid(): Boolean {
        when {
            email.isEmpty() -> formValidationLiveData.value = FormMessage(email = "Please enter Email ID", isEmailError = true)
            !email.isValidEmail() -> formValidationLiveData.value = FormMessage(email = "Please enter a valid Email ID", isEmailError = true)
            password.isEmpty() -> formValidationLiveData.value = FormMessage(password = "Please enter password", isPasswordError = true)
            !password.isValidPasswordLength() -> formValidationLiveData.value = FormMessage(password = "Password must contains 6 character", isPasswordError = true)
            else -> {
                formValidationLiveData.postValue(FormMessage(formIsValid = R.string.form_is_valid))
                return true
            }
        }
        return false
    }

    /**
     * This data class is used to return error message for login screen
     */
    data class FormMessage(
            var email: String = "",
            var password: String = "",
            var isEmailError: Boolean = false,
            var isPasswordError: Boolean = false, @StringRes val formIsValid: Int = 0
    )

    val formValidationLiveData = MutableLiveData<FormMessage>()

}