plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

val major = 0
val minor = 0
val patch = 1

android {
    namespace = "com.example.rickandmortyclean"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.rickandmortyclean"
        minSdk = 24
        targetSdk = 34
        versionCode = major * 10000 + minor * 1000 + patch * 100
        versionName = "$major.$minor.$patch"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.gson)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.retrofit.logging.interceptor)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.coil)
    implementation(libs.androidx.lifecycle.viewmodel.android)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)


}