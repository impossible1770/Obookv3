plugins {
    id("android-library-convention")
}

android {


        namespace = "com.icompany.uicomponents"

    buildFeatures {
        compose = true
    }

}

dependencies {
    implementation(libs.composeUI)
    implementation(libs.composeMaterial)
    implementation(libs.composeUITooling)
    implementation(libs.composeFoundation)
    implementation(libs.stateUtils)
}