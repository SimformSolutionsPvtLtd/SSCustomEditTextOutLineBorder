package shweta.com.customedittextoutlinedborder

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.DrawableContainer.DrawableContainerState
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.text.InputFilter
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import kotlinx.android.synthetic.main.layout_custom_edittext.view.editText
import kotlinx.android.synthetic.main.layout_custom_edittext.view.lableError
import kotlinx.android.synthetic.main.layout_custom_edittext.view.lableTitle

@InverseBindingMethods(value = [InverseBindingMethod(type = CustomComponent::class, attribute = "textValue", event = "android:textAttrChanged", method = "getTextValue"),
    InverseBindingMethod(type = CustomComponent::class, attribute = "errorTextValue"),
    InverseBindingMethod(type = CustomComponent::class, attribute = "isErrorEnable")])
class CustomComponent @JvmOverloads constructor(context: Context, attrs: AttributeSet?, defStyle: Int = 0, defStyleRes: Int = 0) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    val getTextValue: String
        get() {
            return editText.text.toString()
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_custom_edittext, this, true)
        orientation = VERTICAL

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.custom_component_attributes, 0, 0)
            val title = resources.getText(typedArray.getResourceId(R.styleable.custom_component_attributes_custom_component_title, R.string.app_name))
            val editTextHint = resources.getText(typedArray.getResourceId(R.styleable.custom_component_attributes_custom_component_editText_hint, R.string.app_name))
            val isErrorEnable = typedArray.getBoolean(R.styleable.custom_component_attributes_isErrorEnable, false)
            val inputType = typedArray.getInt(R.styleable.custom_component_attributes_android_inputType, EditorInfo.TYPE_TEXT_VARIATION_NORMAL)
            val maxLine = typedArray.getInt(R.styleable.custom_component_attributes_custom_component_maxline, 1)
            val minLine = typedArray.getInt(R.styleable.custom_component_attributes_custom_component_minline, 1)
            val maxLength = typedArray.getInt(R.styleable.custom_component_attributes_custom_component_maxLength, 99)
            val titleBgColor = typedArray.getColor(R.styleable.custom_component_attributes_custom_component_title_bg_color, ContextCompat.getColor(context, R.color.colorPrimary))
            val editTextBgColor = typedArray.getColor(R.styleable.custom_component_attributes_custom_component_editText_bg_color, ContextCompat.getColor(context, R.color.colorPrimary))

            setTitle(title as String)
            setEditTextHint(editTextHint as String)
            setTextStyle(ResourcesCompat.getFont(context, R.font.graphik_regular))
            setIsErrorEnable(isErrorEnable)
            setStyle(inputType, maxLine, minLine, maxLength)
            setTitleBackGroundColor(titleBgColor)
            setEditTextBackGroundColor(editTextBgColor)

            typedArray.recycle()
        }
    }

    fun setIsErrorEnable(isShown: Boolean) {
        if (isShown) {
            setTitleColor(ContextCompat.getColor(context, R.color.color_error))
            setBackgroundErrorColor(ContextCompat.getColor(context, R.color.color_error))
            lableError.visibility = View.VISIBLE
        } else {
            setTitleColor(ContextCompat.getColor(context, R.color.color_brownish_grey_two))
            setBackgroundErrorColor(ContextCompat.getColor(context, R.color.color_warm_grey))
            lableError.visibility = View.GONE
        }
    }

    private fun setTitleColor(@ColorInt colorID: Int) {
        lableTitle.setTextColor(colorID)
    }

    private fun setTitle(title: String) {
        lableTitle.text = title
    }

    private fun setTitleBackGroundColor(@ColorInt colorID: Int) {
        lableTitle.setBackgroundColor(colorID)
    }

    private fun setEditTextBackGroundColor(@ColorInt colorID: Int) {
        val drawable = editText.background as StateListDrawable
        val dcs = drawable.constantState as DrawableContainerState?
        val drawableItems = dcs!!.children
        val gradientDrawableChecked = drawableItems[0] as GradientDrawable
        gradientDrawableChecked.setColor(colorID)
    }

    private fun setEditTextHint(hint: String) {
        editText.hint = hint
    }

    private fun setStyle(inputType: Int, maxLine: Int, minLine: Int, maxLength: Int) {
        editText.inputType = inputType
        editText.apply {
            maxLines = maxLine
            minLines = minLine
            gravity = Gravity.TOP or Gravity.START
            filters = arrayOf(InputFilter.LengthFilter(maxLength))
        }
    }

    private fun setBackgroundErrorColor(@ColorInt colorID: Int) {
        val drawable = editText.background as StateListDrawable
        val dcs = drawable.constantState as DrawableContainerState?
        val drawableItems = dcs!!.children
        val gradientDrawableChecked = drawableItems[0] as GradientDrawable
        gradientDrawableChecked.setStroke(2, colorID)
    }

    private fun setTextStyle(textStyle: Typeface?) {
        lableTitle.typeface = textStyle
        editText.typeface = textStyle
        lableError.typeface = textStyle
    }
}