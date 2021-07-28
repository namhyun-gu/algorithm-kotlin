package io.github.namhyungu.algorithm

open class WriteReadmePluginExtension {
    var title: String? = null
    var sourceDirs: List<Source> = emptyList()
}

data class Source(val name: String, val path: String)

fun sourceOf(name: String, path: String): Source = Source(name, path)