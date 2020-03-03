rootProject.name = "sample-lib"

enableFeaturePreview("GRADLE_METADATA")

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.jetbrains.kotlin.multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
        }
    }
    repositories {
        mavenLocal()
        jcenter()
        maven {
            setUrl("https://dl.bintray.com/kotlin/kotlin-dev")
        }
        gradlePluginPortal()
    }
}