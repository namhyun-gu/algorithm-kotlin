package programmers.kakao.blind_recruitment.v2020

// TODO: 효율성 테스트를 통과하지 못 함
class SearchLyrics {
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val answer = IntArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            val inverse = query.wildcard().inverse(query.length)
            val sliceQuery = query.slice(inverse ?: query.indices)

            answer[i] = words.filter { it.length == query.length }
                    .map { it.slice(inverse ?: it.indices) }
                    .filter { it == sliceQuery }
                    .size
        }
        return answer
    }

    fun String.wildcard() = indexOfFirst { it == '?' }..indexOfLast { it == '?' }

    fun IntRange.inverse(length: Int): IntRange? {
        if (endInclusive - start == length) return null
        return if (start == 0) endInclusive + 1 until length
        else 0 until start
    }
}