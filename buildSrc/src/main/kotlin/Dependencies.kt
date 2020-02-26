/**
 * Contains gradle plugins
 * */
object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinExtensions = "kotlin-android-extensions"
    const val kapt = "kotlin-kapt"
}

/**
 * Contains gradle app configs
 * */
object Configs {
    const val applicationId = "com.pooltrader"
    const val compileSdkVersion = 29
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
    const val versionCode = 1
    const val versionName = "1.0"
}

/**
 * Contains all the versions of libraries, plugins, classpaths, etc used in gradle files
 * */
object Versions {
    // project build.gradle.kts
    const val gradlePlugin = "3.5.2"
    const val googleServicesPlugin = "4.3.2"

    // kotlin
    const val kotlin = "1.3.50"
    const val ktx = "1.1.0"
    const val kotlinCoroutines = "1.3.2"
    const val koin = "2.0.1"

    // android
    const val supportAppCompat = "1.1.0"
    const val constraintLayout = "1.1.3"


    const val sdp = "1.0.6"
    const val ssp = "1.0.6"
    const val timber = "4.7.1"

    // arch
    const val lifecycle_version = "2.1.0"
    const val archVersion = "2.2.0-rc02"

}

/**
 * Contains classpaths for gradle files
 * */
object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val googleServicesPlugin = "com.google.gms:google-services:${Versions.googleServicesPlugin}"
    const val githubMaven = "com.github.dcendents:android-maven-gradle-plugin:2.1"
}

/**
 * Contains dependencies for gradle files
 * */
object Libs {

    /**
     * Contains kotlin related dependencies
     * */
    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
        const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_version}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
        const val viewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.archVersion}"
    }

    /**
     * Contains android core related dependencies
     * */
    object Android {
        const val support = "com.android.support:support-v4:28.0.0-alpha1"
    }

    /**
     * Contains androidx dependencies
     * */
    object Androidx {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.supportAppCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    }


    const val sdp = "com.intuit.sdp:sdp-android:${Versions.sdp}"
    const val ssp = "com.intuit.ssp:ssp-android:${Versions.ssp}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

/**
 * Contains dependencies for unit test
 * */

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.1.1"
        const val espresso = "3.2.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val extJunit = "androidx.test.ext:junit:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

/**
 * Contains urls for gradle.
 */
object Urls {
    const val jitPack = "https://jitpack.io"
    const val fabric = "https://maven.fabric.io/public"
}