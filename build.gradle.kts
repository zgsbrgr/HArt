buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.hiltAndroid)
        classpath(Build.sqlDelightGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")

    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}