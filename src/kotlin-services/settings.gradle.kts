pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
    }
}

rootProject.name = "kotlin-services"
include("shared")
findProject(":shared")?.name = "shared"
include("services:catalog")
findProject(":services:catalog")?.name = "catalog"
include("services:customer")
findProject(":services:customer")?.name = "customer"
include("services:location")
findProject(":services:location")?.name = "location"
include("services:payment")
findProject(":services:payment")?.name = "payment"
include("services:rental")
findProject(":services:rental")?.name = "rental"
include("services:staff")
findProject(":services:staff")?.name = "staff"
include("services:store")
findProject(":services:store")?.name = "store"
include("shared")
