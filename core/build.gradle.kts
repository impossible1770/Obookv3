plugins {
    id("android-library-convention")
}

android {
    namespace = "com.icompany.core"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.navigation)

    implementation(libs.activityKtx)
    implementation(libs.appcompat)
    implementation(libs.composeUI)
    implementation(libs.material)
    implementation(libs.dagger)
    implementation(libs.daggerCompiler)
    implementation(libs.fragmentKtx)
    implementation(libs.stateUtils)
    implementation(libs.timber)
}