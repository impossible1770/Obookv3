import com.android.build.gradle.BaseExtension

plugins {
    id("com.android.library")
    id("kotlin-jvm-convention")
    id("base-android-convention")
    kotlin("kapt")
}

configure<BaseExtension> {

    buildFeatures.buildConfig = true
    composeOptions.kotlinCompilerExtensionVersion = "1.4.5"


    buildTypes {
        getByName("release") {
            consumerProguardFiles("consumer-rules.pro")
        }
        getByName("debug") {
            consumerProguardFiles("consumer-rules.pro")
        }
    }
}
