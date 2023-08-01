plugins {
    id("android-library-convention")
    id("com.google.devtools.ksp")
    id ("org.jetbrains.kotlin.plugin.serialization")

}



android {
    namespace = "com.icompany.commondatabase"


}

dependencies {
    implementation(libs.room)
    ksp(libs.roomCompiler)
    implementation(libs.kotlinSerialization)
    implementation("com.google.code.gson:gson:2.8.6")


    /*    implementation(libs.moshiKotlin)
        implementation(libs.moshiAdapters)*/
}