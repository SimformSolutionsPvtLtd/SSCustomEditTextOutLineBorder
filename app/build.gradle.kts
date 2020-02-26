plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinExtensions)
    id(Plugins.kapt)
}

android {
    compileSdkVersion(Configs.compileSdkVersion)
    defaultConfig {
        applicationId = applicationId
        minSdkVersion(Configs.minSdkVersion)
        targetSdkVersion(Configs.targetSdkVersion)
        versionCode = Configs.versionCode
        versionName = Configs.versionName
        dataBinding.isEnabled = true
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    /*tasks.withType <KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }*/

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation {
        +Libs.Kotlin.stdLib
        +Libs.Androidx.appCompat
        +Libs.Kotlin.ktxCore
        +Libs.Kotlin.coroutinesAndroid
        +Libs.Kotlin.viewModelKtx
        +Libs.sdp
        +Libs.ssp
        +Libs.timber
        +Libs.Androidx.constraintLayout
        +Libs.Kotlin.lifecycle
    }

    implementation(project(":customedittextoutlinedborder"))
}
