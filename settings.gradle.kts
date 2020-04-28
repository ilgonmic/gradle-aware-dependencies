rootProject.name = "sample-app"

pluginManagement {
    repositories {
        maven("https://dl.bintray.com/kotlin/kotlin-dev")
        jcenter()
        gradlePluginPortal()
    }
}

include("sample-lib-gradle-kotlin-dsl")