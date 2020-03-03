rootProject.name = "sample-app"

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
        maven {
            setUrl("https://dl.bintray.com/kotlin/kotlin-dev")
        }
        jcenter()
        gradlePluginPortal()
    }
}

//include(":sample-lib-gradle-kotlin-dsl")