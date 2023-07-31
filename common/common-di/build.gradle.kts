plugins {
    id("android-library-convention")
}

android {


        namespace = "com.icompany.commondi"

    buildFeatures {
        compose = true
        buildConfig = true

    }

}
dependencies {
    implementation(libs.composeActivity)
    implementation(libs.dagger)
    kapt(libs.daggerCompiler)
    implementation(libs.kotlinStdlib)
    implementation(libs.viewModelScope)
    implementation(libs.voyagerNavigator)
    implementation(libs.voyagerViewModel)
}