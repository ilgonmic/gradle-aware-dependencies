plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.4.0-dev-7825"
}

group = "com.example"
version = "1.0"

repositories {
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-dev")
}

kotlin {
    val nodeJs = js("nodeJs")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":sample-lib-gradle-kotlin-dsl"))
            }
        }
        nodeJs.compilations["main"].defaultSourceSet {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-js")
            }
        }
    }
}