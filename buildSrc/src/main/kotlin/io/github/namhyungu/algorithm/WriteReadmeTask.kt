package io.github.namhyungu.algorithm

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.getByType
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.Writer

private val PATH_SEP = System.getProperty("file.separator")

open class WriteReadmeTask : DefaultTask() {

    init {
        description = "Write README from project files."
    }

    @TaskAction
    fun task() {
        val extension = project.extensions.getByType(WriteReadmePluginExtension::class)
        if (extension.sourceDirs.isEmpty()) {
            throw IllegalArgumentException("Require 'sourceDirs' property.")
        }
        if (extension.title == null) {
            throw IllegalArgumentException("Require 'title' property.")
        }

        val title = extension.title!!
        val sourceDirs = extension.sourceDirs
        val sourceFilesGroup = mutableMapOf<String, Map<String, List<File>>>()

        sourceDirs.forEach { (name, path) ->
            val files = getFiles(File(path)).filter { file ->
                file.extension in arrayOf("java", "kt") // For only java, kotlin files
            }.groupBy { file ->
                file.parent.split(PATH_SEP).last() // Group by last path name
            }
            sourceFilesGroup[name] = files
        }

        val output = BufferedWriter(FileWriter("README.md"))
        val writer = MarkdownWriter(output)

        writeReadme(writer, title, sourceFilesGroup)
    }

    private fun getFiles(root: File): List<File> {
        val files = mutableListOf<File>()
        root.listFiles()?.forEach { file ->
            if (file.isDirectory) {
                files += getFiles(file)
            } else {
                files += file
            }
        }
        return files
    }

    private fun writeReadme(
        writer: MarkdownWriter,
        title: String,
        sourceFilesGroup: Map<String, Map<String, List<File>>>
    ) {
        val filesGroup = sourceFilesGroup.values.first()

        writer.build {
            title(title)
            newLine()

            filesGroup.keys.forEach { group ->
                list(link(group.replace("_", " "), group.replace("_", "-")))
            }
            newLine()

            filesGroup.forEach { group, files ->
                subtitle(group.replace("_", " "))
                newLine()
                files.forEach { file ->
                    list(link(file.name, file.path))
                }
                newLine()
            }
        }.flush()
    }

    private fun writeLink(out: Writer, name: String, url: String) {
        out.write("[$name]($url)")
    }
}