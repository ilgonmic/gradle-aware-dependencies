plugins {
    id("org.jetbrains.kotlin.multiplatform").version("1.4-SNAPSHOT")
    id("maven-publish")
}

group = "com.example"
version = "1.0"

repositories {
    mavenLocal()
    jcenter()
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

configurations {
    all {
        if (name.toLowerCase().endsWith("default") ||name.toLowerCase().endsWith("compile") || name.toLowerCase().endsWith("compileOnly")|| name.toLowerCase().endsWith("runtime")|| name.toLowerCase().endsWith("runtimeOnly")) {
            println(this)
            isCanBeConsumed = false
        }
    }
}