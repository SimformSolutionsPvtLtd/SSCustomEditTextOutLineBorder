# README #

# SSCustomEditTextOutlineBorder

[![](https://jitpack.io/v/SimformSolutionsPvtLtd/SSCustomEditTextOutLineBorder.svg)](https://jitpack.io/#SimformSolutionsPvtLtd/SSCustomEditTextOutLineBorder)
[![Kotlin Version](https://img.shields.io/badge/Kotlin-v1.7.0-blue.svg)](https://kotlinlang.org)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg?style=flat)](https://www.android.com/)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![Android Weekly](https://img.shields.io/badge/Android%20Weekly-%23402-orange)](https://androidweekly.net/issues/issue-402)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-SSCustomEditTextOutLineBorder-green.svg?style=flat )]( https://android-arsenal.com/details/1/8072)

Getting Started
------------------------
`SSCustomEditTextOutLineBorder` is a small kotlin library for android to support outlined (stroked) text in EditText widgets same as [Material Design Outlined Box](https://material.io/develop/android/components/text-input-layout/) but without Floating Label. 

The actual features are:

 * Outlined text fields with a label which have custom-built text, color, errorColor and backgroundColor.
 * Outlined box border has customizable color and errorColor.
 * EditText with custom-made backgroundColor, hint text, max-min line, max length.
 * Error color customized with error enabled or not.
 
### Demo
------------------------
 
![demo_data](https://github.com/simformsolutions/CustomEditTextOutLineBorder/blob/master/images/demo_new.gif)

### Gradle Dependency
* Add the JitPack repository to your project's build.gradle file

    - For Gradle version 5.x.x or less
    ```
    allprojects {
        repositories {
        ...
        maven { url 'https://jitpack.io' }
        }
    }
    ```
    - For Gradle version 6.x.x and above, in settings.gradle file inside `pluginManagement` block
    ```
      pluginManagement {
        repositories {
        ...
        maven { url 'https://jitpack.io' }
        }
    }
    ```

* Add the dependency in your app's build.gradle file

```
dependencies {
	implementation 'com.github.simformsolutions:SSCustomEditTextOutLineBorder:1.0.15'
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
| `app:custom_component_title_color` | Set Outlined title color | `#666666` |
| `app:custom_component_title_error_color` | Set Outlined title error color | `#f15454` |
| `app:custom_component_border_color` | Set Outlined border color | `#979797` |
| `app:custom_component_border_error_color` | Set Outlined border error color | `#f15454` |
| `app:custom_component_title_bg_color` | Set Outlined border title background color | `R.color.colorPrimary` |
| `app:custom_component_editText_bg_color` | Set EditText background color | `R.color.colorPrimary` |
| `app:custom_component_maxLength` | Set EditText maxLength | `99` |
| `android:inputType` | Set EditText inputType | `EditorInfo.TYPE_TEXT_VARIATION_NORMAL` |
| `app:custom_component_border_width` | Set Outlined border width | `1` |
| `app:isToggleEnable` | Whether Password Toggle is enabled | `false` |

### Usage
------------------------

```
<com.simform.customcomponent.SSCustomEdittextOutlinedBorder
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
            app:isToggleEnable = "true"
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

## Find this library useful? :heart:
Support it by joining __[stargazers](https://github.com/simformsolutions/SSCustomEditTextOutLineBorder/stargazers)__ for this repository. :star:

## 🤝 How to Contribute

Whether you're helping us fix bugs, improve the docs, or a feature request, we'd love to have you! :muscle:

Check out our [**Contributing Guide**](https://github.com/SimformSolutionsPvtLtd/SSCustomEditTextOutLineBorder/blob/master/CONTRIBUTING.md) for ideas on contributing.

## Bugs and Feedback

For bugs, feature requests, and discussion please use [GitHub Issues](https://github.com/SimformSolutionsPvtLtd/SSCustomEditTextOutLineBorder/issues).

## Awesome Mobile Libraries
- Check out our other available [awesome mobile libraries](https://github.com/SimformSolutionsPvtLtd/Awesome-Mobile-Libraries)

## License

```
Copyright 2020 Simform Solutions

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
