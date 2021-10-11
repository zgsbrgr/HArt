apply {
    from("$rootDir/android-library-build.gradle")
}

plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.domainModels))
    "implementation"(project(Modules.domainInteractor))
}