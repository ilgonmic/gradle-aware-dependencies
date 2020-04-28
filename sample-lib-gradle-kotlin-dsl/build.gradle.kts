plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

group = "com.example"
version = "1.0"

repositories {
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-dev")
}

kotlin {
    val js = js("nodeJs")

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib-common"))
            }
        }
        js.compilations["main"].defaultSourceSet {
            dependencies {
                api(kotlin("stdlib-js"))
            }
        }
    }
}