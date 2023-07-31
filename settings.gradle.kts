enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ComposeMultiModuleTemplate"

includeBuild("build-logic")
include(
    "app",
    "core",
    "navigation",
    "uicomponents",
    "common:common-network",
    "common:common-database",
    "common:common-di"
)
include(
    "features:splash",
)
include(
    "features:clients:feature-clients-domain",
    "features:clients:feature-clients"
)
include(
    "features:products:feature-products",
    "features:products:feature-products-domain"
)

pluginManagement {

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://jitpack.io")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
}
include(":features:mylibrary")
