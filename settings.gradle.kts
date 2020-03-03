rootProject.name = "sample-app"

enableFeaturePreview("GRADLE_METADATA")

pluginManagement {
    repositories {
        mavenLocal()
        jcenter()
        gradlePluginPortal()
    }
}

//include(":sample-lib-gradle-kotlin-dsl")