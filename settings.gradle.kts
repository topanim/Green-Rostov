pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GreenRostovPrivate"
include(":app")
include(":core:ui")
include(":core:domain")
include(":core:navigation")
include(":core:foundation")
include(":core:api-sdk")
include(":features:main")
include(":features:auth")
include(":features:splash")
include(":features:events")
include(":features:profile")
include(":features:assistant")
