@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        jcenter()
        mavenCentral()
        flatDir {
            dirs("libs")
        }
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        jcenter()
        mavenCentral()
        flatDir {
            dirs("libs")
        }
        maven { url = uri("https://jitpack.io") }
    }

}

rootProject.name = "DecompiledApk"
include(":app")
 