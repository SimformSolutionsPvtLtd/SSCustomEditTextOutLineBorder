# README #

# CustomEditTextOutlineBorder

[![Kotlin Version](https://img.shields.io/badge/Kotlin-v1.3.50-blue.svg)](https://kotlinlang.org)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

Getting Started
------------------------
CustomEditTextOulinedBorder is a small kotlin library. It's same as Material Design Outlined Box but it's with some dynamic feature for error display, dynamic stroke color, dynamic lable color, lable and hint both in EditText.

### Gradle Dependency
* Add the JitPack repository to your project's build.gradle file

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

* Add the dependency in your app's build.gradle file

```
dependencies {
	implementation 'com.github.simformsolutions:CustomEditTextOutLineBorder:1.0.2'
}
```

### All Attributes
------------------------

| Attribute | Description | Default |
| --- | --- | --- |
| `app:isErrorEnable` | Whether the EditText error is enabled | `false` |
| `app:custom_component_title` | Set Outlined border title text | `R.string.app_name` |
| `app:custom_component_editText_hint` | Set EditText hint | `R.string.app_name` |
| `app:custom_component_maxline` | Set maximum height of the EditText | `1` |
| `app:custom_component_minline` | Set minimum height of the EditText | `1` |
| `app:custom_component_title_color` | Set Outlined border color | `#666666` |
| `app:custom_component_title_error_color` | Set Outlined border color | `#f15454` |
| `app:custom_component_border_color` | Set Outlined border color | `#979797` |
| `app:custom_component_border_error_color` | Set Outlined border color | `#f15454` |
| `app:custom_component_title_bg_color` | Set Outlined border title background color | `R.color.colorPrimary` |
| `app:custom_component_editText_bg_color` | Set EditText background color | `R.color.colorPrimary` |
| `app:custom_component_maxLength` | Set EditText maxLength | `99` |
| `android:inputType` | Set EditText inputType | `EditorInfo.TYPE_TEXT_VARIATION_NORMAL` |

* Example
```
<simform.com.customedittextoutlinedborder.CustomComponent
            android:id="@+id/edtAbout"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginTop="@dimen/_10sdp"
            android:inputType="textMultiLine|textCapSentences"
            app:custom_component_editText_hint="@string/edt_hint_about"
            app:custom_component_maxline="3"
            app:custom_component_minline="3"
            app:custom_component_maxLength="25"
            app:errorTextValue="errorText"
            app:isErrorEnable="false"
            app:custom_component_title_color="@color/color_brownish_grey_two"
            app:custom_component_title_error_color="@color/color_error"
            app:custom_component_border_color="@color/color_warm_grey"
            app:custom_component_border_error_color="@color/color_error"
            app:custom_component_title="@string/edt_title_about"
            app:layout_constraintEnd_toEndOf="@+id/edtPassword"
            app:layout_constraintStart_toStartOf="@+id/edtPassword"
            app:layout_constraintTop_toBottomOf="@+id/edtPassword"
            app:textValue="aboutText"/>
```

![](images/test_3.png)