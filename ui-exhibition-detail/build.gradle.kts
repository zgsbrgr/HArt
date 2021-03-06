apply {
    from("$rootDir/android-library-build.gradle")
}



dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.domainModels))
    "implementation"(project(Modules.domainInteractor))
    "implementation"(project(Modules.commonUiCompose))
    "implementation"(Coil.coil)
}