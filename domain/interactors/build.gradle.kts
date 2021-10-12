apply {
    from("$rootDir/android-library-build.gradle")

}


dependencies {

    "implementation"(Kotlinx.coroutinesCore) // need for flows
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.domainModels))
    //"implementation"(project(Modules.data))

}