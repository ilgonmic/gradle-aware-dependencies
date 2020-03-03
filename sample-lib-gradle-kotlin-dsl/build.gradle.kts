plugins {
    id("org.jetbrains.kotlin.multiplatform").version("1.4.0-dev-3635")
    id("maven-publish")
}

group = "com.example"
version = "1.0"

repositories {
    mavenLocal()
    jcenter()
    maven {
        setUrl("https://dl.bintray.com/kotlin/kotlin-dev")
    }
}

kotlin {
    val js = js("nodeJs")

    targets.all {
        mavenPublication(Action<MavenPublication> {
            pom.withXml(Action<XmlProvider> {
                asNode().appendNode("name", "Sample MPP library")
            })
        })
    }

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

publishing {
    repositories {
        maven { setUrl("file://${projectDir.absolutePath.replace('\\', '/')}/repo") }
    }
}