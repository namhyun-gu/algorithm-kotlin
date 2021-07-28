package io.github.namhyungu.algorithm

import java.io.Flushable
import java.io.Writer

class MarkdownWriter(val writer: Writer) : Flushable {
    fun build(scope: MarkdownWriter.() -> Unit): MarkdownWriter {
        scope(this)
        return this
    }

    fun title(title: String) {
        writer.write("# $title\n")
    }

    fun subtitle(subtitle: String) {
        writer.write("## $subtitle\n")
    }

    fun link(name: String, url: String): String {
        return "[$name]($url)"
    }

    fun list(content: String) {
        writer.write("- $content\n")
    }

    fun newLine() {
        writer.write("\n")
    }

    override fun flush() {
        writer.flush()
    }
}