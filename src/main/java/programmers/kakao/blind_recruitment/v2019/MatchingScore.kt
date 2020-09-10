package programmers.kakao.blind_recruitment.v2019

// Reference: https://leveloper.tistory.com/110
class MatchingScore {
    data class Page(val idx: Int, val originUrl: String, val links: List<String>, val defaultScore: Int, var linkScore: Double = 0.0) {
        val matchingScore
            get() = defaultScore + linkScore
    }

    val pageMap = mutableMapOf<String, Page>()

    fun solution(word: String, pages: Array<String>): Int {
        pages.mapIndexed { idx, str -> parsePage(idx, str.toLowerCase(), word.toLowerCase()) }
                .forEach { pageMap[it.originUrl] = it }

        pageMap.forEach { (_, page) ->
            page.links.forEach {
                if (pageMap.containsKey(it)) {
                    pageMap[it]!!.linkScore += page.defaultScore / page.links.size.toDouble()
                }
            }
        }

        var maxMatchingScore = Double.MIN_VALUE
        var maxIdx = 0
        pageMap.values.forEach { page ->
            if (page.matchingScore > maxMatchingScore) {
                maxMatchingScore = page.matchingScore
                maxIdx = page.idx
            }
        }
        return maxIdx
    }

    fun parsePage(idx: Int, html: String, word: String): Page {
        val originUrl = findOriginUrl(html)
        val links = findLink(html)
        val defaultScore = calculateDefaultScore(html, word)

        return Page(idx, originUrl, links, defaultScore)
    }

    fun findOriginUrl(html: String): String {
        val pattern = "<meta property=\"og:url\" content=\"https://(.+?)\"/>".toPattern()
        val matcher = pattern.matcher(html)

        return if (matcher.find()) matcher.group(1)
        else ""
    }

    fun findLink(html: String): List<String> {
        val pattern = "<a href=\"https://(.+?)\">".toPattern()
        val matcher = pattern.matcher(html)
        val links = mutableListOf<String>()

        while (matcher.find()) {
            links.add(matcher.group(1))
        }
        return links
    }

    fun calculateDefaultScore(html: String, word: String): Int {
        var idx = html.indexOf(word)
        var defaultScore = 0
        while (idx >= 0) {
            if (!html[idx - 1].isLowerCase() && !html[idx + word.length].isLowerCase()) {
                defaultScore++
            }
            idx = html.indexOf(word, idx + 1)
        }
        return defaultScore
    }
}