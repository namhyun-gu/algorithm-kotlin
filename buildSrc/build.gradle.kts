plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("ReadmeWriterPlugin") {
            id = "io.github.namhyungu.plugin.writereadme"
            implementationClass = "io.github.namhyungu.algorithm.WriteReadmePlugin"
        }
    }
}