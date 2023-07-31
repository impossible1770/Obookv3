plugins {
    id("android-library-convention")
}

android {
    namespace = "com.icompany.profile_domain"
}

dependencies {
    implementation(projects.common.commonDi)
    implementation(projects.common.commonNetwork)
    implementation(libs.dagger)
    kapt(libs.daggerCompiler)
    implementation(libs.retrofit)
    implementation(libs.moshiKotlin)
    implementation(libs.stateUtils)
}