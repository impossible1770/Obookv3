plugins {
    id("android-library-convention")
}

android {
    namespace = "com.icompany.navigation"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.voyagerNavigator)

    implementation(libs.dagger)
    kapt(libs.daggerCompiler)
    implementation(libs.fragmentKtx)
}