pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() //here
        flatDir {
            dirs("libs")
        }
    }
}



rootProject.name = "viridium_implementation"
include(":app",":veridium-core-release",":veridium-analytics-release",":veridium-fourf-release",":veridium-fourf-ui-release",":veridiumid-sdk-release",":veridium-secure-data-release",":veridium-settings-ui-release",":veridium-support-release")
 