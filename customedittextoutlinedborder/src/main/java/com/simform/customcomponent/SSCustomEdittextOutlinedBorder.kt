package com.simform.customcomponent

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.DrawableContainer.DrawableContainerState
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import kotlinx.android.synthetic.main.layout_custom_edittext.view.*

@InverseBindingMethods(value = [InverseBindingMethod(type = SSCustomEdittextOutlinedBorder::class, attribute = "textValue", event = "android:textAttrChanged", method = "getTextValue"),
    InverseBindingMethod(type = SSCustomEdittextOutlinedBorder::class, attribute = "errorTextValue"),
    InverseBindingMethod(type = SSCustomEdittextOutlinedBorder::class, attribute = "isErrorEnable")])
class SSCustomEdittextOutlinedBorder @JvmOverloads constructor(context: Context, attrs: AttributeSet?, defStyle: Int = 0, defStyleRes: Int = 0) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    private var titleColor = ContextCompat.getColor(context, R.color.color_brownish_grey_two)
    private var titleErrorColor = ContextCompat.getColor(context, R.color.color_error)
    private var borderColor = ContextCompat.getColor(context, R.color.color_warm_grey)
    private var borderErrorColor = ContextCompat.getColor(context, R.color.color_error)
    private var borderWidth = 1
    private var onTextChangeListener: OnTextChangeListener? = null

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
            val errorTextBgColor = typedArray.getColor(R.styleable.custom_component_attributes_custom_component_error_text_bg_color, ContextCompat.getColor(context, R.color.colorPrimary))
            titleColor = typedArray.getColor(R.styleable.custom_component_attributes_custom_component_title_color, ContextCompat.getColor(context, R.color.color_brownish_grey_two))
            titleErrorColor = typedArray.getColor(R.styleable.custom_component_attributes_custom_component_title_error_color, ContextCompat.getColor(context, R.color.color_error))
            borderColor = typedArray.getColor(R.styleable.custom_component_attributes_custom_component_border_color, ContextCompat.getColor(context, R.color.color_warm_grey))
            borderErrorColor = typedArray.getColor(R.styleable.custom_component_attributes_custom_component_border_error_color, ContextCompat.getColor(context, R.color.color_error))
            borderWidth = typedArray.getInt(R.styleable.custom_component_attributes_custom_component_border_width, 1)
            val isToggleEnable = typedArray.getBoolean(R.styleable.custom_component_attributes_isToggleEnable, false)

            setTitle(title as String)
            setEditTextHint(editTextHint as String)
            setTextStyle(ResourcesCompat.getFont(context, R.font.graphik_regular))
            setIsErrorEnable(isErrorEnable)
            setIsToggleEnable(isToggleEnable)
            setPasswordToggleClick()
            setTextChangeListeners()
            setStyle(inputType, maxLine, minLine, maxLength)
            setTitleBackGroundColor(titleBgColor)
            setEditTextBackGroundColor(editTextBgColor)
            setErrorTextBackGroundColor(errorTextBgColor);

            typedArray.recycle()
        }
    }

    fun setTextValue(value : String?){
        value?.let {
            editText.setText(value)
            editText.setSelection(value.length)
        }
    }

    fun setIsErrorEnable(isShown: Boolean) {
        if (isShown) {
            setTitleColor(titleErrorColor)
            setBackgroundBorderErrorColor(borderErrorColor)
            lableError.visibility = View.VISIBLE
        } else {
            setTitleColor(titleColor)
            setBackgroundBorderErrorColor(borderColor)
            lableError.visibility = View.GONE
        }
    }

    private fun setIsToggleEnable(isToggleEnable: Boolean) {
        imagePasswordToggle.isVisible = isToggleEnable
    }

    private fun setPasswordToggleClick() {
        imagePasswordToggle.setOnClickListener {
            if (editText.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
                imagePasswordToggle.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_baseline_visibility_24
                    )
                )
                editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                imagePasswordToggle.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_baseline_visibility_off_24
                    )
                )
                editText.transformationMethod = PasswordTransformationMethod.getInstance()
            }
            editText.text?.let { text -> editText.setSelection(text.length) }
        }
    }

    fun getClickListener(onclick: () -> Unit) {
        editText.setOnClickListener {
            onclick.invoke()
        }
    }

    interface OnTextChangeListener {
        fun beforeTextChange(s: CharSequence?, start: Int, count: Int, after: Int)
        fun onTextChange(s: CharSequence?, start: Int, count: Int, after: Int)
        fun afterTextChange(s: Editable?)
    }

    fun setOnTextChangeListener(onTextChangeListener: OnTextChangeListener?) {
        this.onTextChangeListener = onTextChangeListener
    }

    private fun setTextChangeListeners() {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                onTextChangeListener?.afterTextChange(s)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                onTextChangeListener?.beforeTextChange(s, start, count, after)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                onTextChangeListener?.onTextChange(s, start, before, count)
            }
        })
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

    private fun setErrorTextBackGroundColor(@ColorInt colorID: Int) {
        lableError.setBackgroundColor(colorID)
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

    private fun setBackgroundBorderErrorColor(@ColorInt colorID: Int) {
        val drawable = editText.background as StateListDrawable
        val dcs = drawable.constantState as DrawableContainerState?
        val drawableItems = dcs!!.children
        val gradientDrawableChecked = drawableItems[0] as GradientDrawable
        gradientDrawableChecked.setStroke(borderWidth, colorID)
    }

    private fun setTextStyle(textStyle: Typeface?) {
        lableTitle.typeface = textStyle
        editText.typeface = textStyle
        lableError.typeface = textStyle
    }
}
