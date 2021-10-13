apply {
    from("$rootDir/android-library-build.gradle")

}


dependencies {

    "implementation"(Kotlinx.coroutinesCore) // need for flows
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.domainModels))
    "testImplementation"(Junit.junit4)
    //"implementation"(project(Modules.data))

}