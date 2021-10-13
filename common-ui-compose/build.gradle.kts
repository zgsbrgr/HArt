apply {
    from("$rootDir/android-library-build.gradle")
}



dependencies {
    "implementation"(Compose.ui)
    "implementation"(Compose.material)
    "implementation"(Compose.tooling)
}