pluginManagement {
    repositories {
        google()
        mavenCentral()
        flatDir {
            dirs("libs")
        }
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        flatDir {
            dirs("libs")
        }
        maven { url = uri("https://jitpack.io") }
    }

}

rootProject.name = "DecompiledApk"
include(":app")
 