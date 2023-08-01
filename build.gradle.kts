
/**
 * Tests run from IDE in included builds can't recognize root wrapper
 * https://youtrack.jetbrains.com/issue/IDEA-262528
 */
plugins {
    id("convention.detekt")
    id("convention.lifecycle")
    id("convention.dependency-updates")
    id("com.google.devtools.ksp") version "1.8.22-1.0.11" apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.8.22" apply false


}

buildscript {

    dependencies {
        classpath(libs.googleServices)
    }

    repositories {
        google()
        mavenCentral()

        maven { url = uri("https://plugins.gradle.org/m2/") }
        gradlePluginPortal()
        flatDir {
            dirs("libs")
        }
    }

    dependencies {
        classpath(libs.androidGradle)
        classpath(libs.kotlinGradle)
    }
}

tasks.withType<Wrapper>().configureEach {
    distributionType = Wrapper.DistributionType.BIN
    gradleVersion = "8.0.1"
}
subprojects {
    if (gradle.startParameter.isConfigureOnDemand &&
        parent != rootProject
    ) {
        generateSequence(parent) { project -> project.parent.takeIf { it != rootProject } }
            .forEach { evaluationDependsOn(it.path) }
    }
}

tasks.register<Exec>("installGitHooks") {
    group = "Build Setup"
    description = "Install local repository git hooks"
    commandLine("git")
    args("config", "core.hooksPath", ".git_hooks")
    onlyIf { !System.getenv("CI").toBoolean() }
}

val initialTaskNames: List<String> = project.gradle.startParameter.taskNames
project.gradle.startParameter.setTaskNames(initialTaskNames + listOf("installGitHooks"))

val checkAll = tasks.named("checkAll") {
    group = "Puls Checks"
    description = "Run all tests and static analysis tools"

    dependsOn(tasks.named("detektAll"))
}
