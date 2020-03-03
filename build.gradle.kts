plugins {
    id("org.jetbrains.kotlin.multiplatform").version("1.4-SNAPSHOT")
    id("maven-publish")
}

group = "com.example"
version = "1.0"

repositories {
    maven {
        setUrl("file://" + projectDir.resolve("sample-lib-gradle-kotlin-dsl").resolve("repo").canonicalPath)
    }
    mavenLocal()
    maven {
        setUrl("https://dl.bintray.com/kotlin/kotlin-dev")
    }
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

//configurations {
//    all {
//        if (name.toLowerCase().endsWith("default") ||name.toLowerCase().endsWith("compile") || name.toLowerCase().endsWith("compileOnly")|| name.toLowerCase().endsWith("runtime")|| name.toLowerCase().endsWith("runtimeOnly")|| name.toLowerCase().endsWith("implementation")|| name.toLowerCase().endsWith("api")) {
//            println(this)
//            println(isCanBeConsumed)
//            isCanBeConsumed = false
//        }
//    }
//}