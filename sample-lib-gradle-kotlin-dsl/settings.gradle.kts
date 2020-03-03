rootProject.name = "sample-lib"

enableFeaturePreview("GRADLE_METADATA")

pluginManagement {
    repositories {
        mavenLocal()
        jcenter()
        maven {
            setUrl("https://dl.bintray.com/kotlin/kotlin-dev")
        }
        gradlePluginPortal()
    }
}