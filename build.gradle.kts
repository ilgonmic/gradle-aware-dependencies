plugins {
    id("org.jetbrains.kotlin.multiplatform").version("1.4.0-dev-3635")
    id("maven-publish")
}

group = "com.example"
version = "1.0"

repositories {
    maven {
        setUrl("https://dl.bintray.com/kotlin/kotlin-dev")
    }
    maven {
        setUrl("file://" + projectDir.resolve("sample-lib-gradle-kotlin-dsl").resolve("repo").canonicalPath)
    }
    mavenLocal()

    jcenter()
}

kotlin {
    val nodeJs = js("nodeJs")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.example:sample-lib:1.0")
            }
        }
        nodeJs.compilations["main"].defaultSourceSet {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-js")
            }
        }
    }
}