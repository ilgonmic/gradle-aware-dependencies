rootProject.name = "sample-app"

enableFeaturePreview("GRADLE_METADATA")

pluginManagement {
    repositories {
        mavenLocal()
        maven {
            setUrl("https://dl.bintray.com/kotlin/kotlin-dev")
        }
        jcenter()
        gradlePluginPortal()
    }
}

//include(":sample-lib-gradle-kotlin-dsl")