package simform.com.customedittextoutlineborder.extention

import android.util.Patterns

/**
 * Check given string is contain at least char and size
 * @receiver String
 * @return Boolean
 */
fun String.isValidPasswordLength(): Boolean {
    return length >= 6
}

/**
 * Thus fun is used to check email is valid or not.
 * @receiver String
 * @return Boolean
 */
fun String.isValidEmail(): Boolean = isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
