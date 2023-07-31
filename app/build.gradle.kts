plugins {
    id("android-application-convention")
    id("dependency-locking-convention")
}

android {
    namespace = "com.icompany.obook"

    lintOptions.disable += "Instantiatable"

    defaultConfig {
        applicationId = "com.icompany.obook"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

}

dependencies {
    implementation(projects.common.commonDi)
    implementation(projects.core)
    implementation(projects.navigation)
    implementation(projects.uicomponents)
    implementation(projects.features.home.featureHome)
    implementation(projects.features.profile.featureProfile)

    implementation(libs.appcompat)
    implementation(libs.dagger)
    kapt(libs.daggerCompiler)
    implementation(libs.material)
    implementation(libs.timber)
    implementation(libs.composeActivity)
    implementation(libs.composeUI)
    implementation(libs.composeMaterial)
    implementation(libs.composeUITooling)
    implementation(libs.composeFoundation)
    implementation(libs.voyagerNavigator)
    implementation(libs.voyagerTabNavigator)
    implementation(libs.voyagerTransitions)
}
