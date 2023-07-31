plugins {
    id("android-library-convention")
}

android {

        namespace = "com.icompany.splash"
    buildFeatures {
        compose = true
    }

}

dependencies {
    implementation(projects.common.commonDi)
    implementation(projects.uicomponents)
    implementation(projects.core)
    implementation(projects.navigation)
    //implementation(projects.features.profile.featureProfileDomain)

    implementation(libs.appcompat)
    implementation(libs.composeUI)
    implementation(libs.composeMaterial)
    implementation(libs.composeUITooling)
    implementation(libs.composeFoundation)
    implementation(libs.material)
    implementation(libs.stateUtils)
    implementation(libs.dagger)
    kapt(libs.daggerCompiler)
    implementation(libs.fragmentKtx)
    implementation(libs.viewModelScope)
    implementation(libs.voyagerNavigator)
    implementation(libs.voyagerViewModel)
    implementation(libs.voyagerTabNavigator)
    implementation(libs.voyagerTransitions)
}