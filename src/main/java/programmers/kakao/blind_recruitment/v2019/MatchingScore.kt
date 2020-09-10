package programmers.kakao.blind_recruitment.v2019

import java.util.*

// TODO: 테스트 통과 X, Regex로 코드 변경하기
class MatchingScore {
    data class Page(val defaultScore: Int, val externalLinkScore: Int) {
        val linkScore: Double
            get() = defaultScore / externalLinkScore.toDouble()

        val matchingScore: Double
            get() = defaultScore + linkScore
    }

    data class Tag(val name: String, val attributes: Map<String, String>)

    fun solution(word: String, pages: Array<String>): Int {
        var maxScore = Double.MIN_VALUE
        var maxIdx = 0
        pages.map { parsePage(it, word) }.forEachIndexed { index, page ->
            if (page.matchingScore > maxScore) {
                maxIdx = index
                maxScore = page.matchingScore
            }
        }
        return maxIdx
    }

    fun containWord(str: String, word: String): Int {
        val chars = str.toLowerCase().map {
            if (it in 'a'..'z') it
            else ' '
        }
        val builder = StringBuilder()
        chars.forEach { builder.append(it) }
        var line = builder.toString()
        var contains = 0

        val tokens = tokenize(line)
        tokens.forEach {
            if (it == word.toLowerCase()) {
                contains++
            }
        }
        return contains
    }

    fun parsePage(page: String, word: String): Page {
        val lines = page.split("\n")
        val urls = mutableListOf<String>()
        var originUrl = ""
        var defaultScore = 0
        lines.map { it.trim() }.forEach {
            parseTags(it).forEach { tag ->
                if (tag.name == "meta" && tag.attributes.containsKey("content")) {
                    originUrl = tag.attributes["content"] ?: ""
                }
                if (tag.name == "a" && tag.attributes.containsKey("href")) {
                    urls.add(tag.attributes["href"] ?: "")
                }
            }
            defaultScore += containWord(it, word)
        }
        val externalLinkScore = urls.filter { !it.startsWith(originUrl) }.size
        return Page(defaultScore, externalLinkScore)
    }

    fun parseTags(content: String): List<Tag> {
        val contents = mutableListOf<Tag>()
        var startIdx = 0
        var endIdx: Int
        content.forEachIndexed { idx, c ->
            when (c) {
                '<' -> startIdx = idx
                '>' -> {
                    endIdx = idx
                    var tagBody = content.substring(startIdx + 1, endIdx)
                    if (tagBody.endsWith("/")) {
                        tagBody = tagBody.removeSuffix("/")
                    }
                    val tag = parseTag(tagBody)
                    contents.add(tag)
                }
            }
        }
        return contents
    }

    fun parseTag(tagBody: String): Tag {
        val attributes = mutableMapOf<String, String>()
        return if (tagBody.startsWith("/")) {
            Tag(tagBody.substring(1), attributes)
        } else {
            val tokens = tokenize(tagBody)
            if (tokens.size > 1) {
                for (idx in 1 until tokens.size) {
                    val attribute = parseAttribute(tokens[idx])
                    attributes[attribute.first] = attribute.second
                }
            }
            Tag(tokens.first(), attributes)
        }
    }

    fun parseAttribute(attributeToken: String): Pair<String, String> {
        val (name, value) = attributeToken.split("=")
        return name to value.removeSurrounding("\"")
    }

    fun tokenize(s: String): List<String> {
        val tokenizer = StringTokenizer(s)
        val tokens = mutableListOf<String>()
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken())
        }
        return tokens
    }
}