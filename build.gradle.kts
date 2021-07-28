import io.github.namhyungu.algorithm.sourceOf

plugins {
    kotlin("jvm") version "1.5.10"
    id("com.diffplug.spotless") version "5.14.1"
    id("io.github.namhyungu.plugin.writereadme")
}

group = "io.github.namhyungu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
}

configure<io.github.namhyungu.algorithm.WriteReadmePluginExtension> {
    title = "algorithm"
    sourceDirs = listOf(
        sourceOf("baekjoon", "src/main/kotlin/io/github/namhyungu/algorithm/baekjoon")
    )
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    java {
        target("src/**/*.java")
        googleJavaFormat()
    }
    kotlin {
        target("src/**/*.kt")
        ktfmt().kotlinlangStyle()
    }
}