plugins {
    id("android-library-convention")
}

android {
    namespace = "com.icompany.commonnetwork"

}

dependencies {
    implementation(projects.common.commonDi)

    implementation(libs.dagger)
    kapt(libs.daggerCompiler)
    implementation(libs.httpLoggingInterceptor)
    implementation(libs.kotlinStdlib)
    implementation(libs.moshiKotlin)
    implementation(libs.moshiAdapters)
    implementation(libs.retrofit)
    implementation(libs.retrofitMoshiConverter)
    implementation(libs.stateUtils)

    debugImplementation(libs.chuck)

    releaseImplementation(libs.chuckNoOp)
}
