pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
    }
}

rootProject.name = "kotlin-services"
include("services:catalog-service")
findProject(":services:catalog-service")?.name = "catalog-service"
include("services:customer-service")
findProject(":services:customer-service")?.name = "customer-service"
include("services:location-service")
findProject(":services:location-service")?.name = "location-service"
include("services:payment-service")
findProject(":services:payment-service")?.name = "payment-service"
include("services:rental-service")
findProject(":services:rental-service")?.name = "rental-service"
include("services:staff-service")
findProject(":services:staff-service")?.name = "staff-service"
include("services:store-service")
findProject(":services:store-service")?.name = "store-service"
