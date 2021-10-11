apply {
    from("$rootDir/library-build.gradle")

}

plugins {
    id("kotlin-kapt")
}

dependencies {

    "implementation"(Kotlinx.coroutinesCore) // need for flows
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.domainModels))
    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)
}