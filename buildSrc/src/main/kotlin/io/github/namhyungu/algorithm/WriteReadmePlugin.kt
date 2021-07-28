package io.github.namhyungu.algorithm

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.register

class WriteReadmePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            extensions.create("readmeWriter", WriteReadmePluginExtension::class)
            tasks.register("writeReadme", WriteReadmeTask::class)
        }
    }
}