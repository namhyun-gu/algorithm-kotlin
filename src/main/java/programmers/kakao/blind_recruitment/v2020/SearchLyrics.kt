package programmers.kakao.blind_recruitment.v2020

// Reference: https://biewoom.github.io/coding%20test/kakao%202020%20blind/2020/04/13/search_lyrics.html
// Reference (2) : https://mishuni.tistory.com/46
class SearchLyrics {
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val prefixTrie = mutableMapOf<Int, Trie>()
        val suffixTrie = mutableMapOf<Int, Trie>()
        val lenMap = mutableMapOf<Int, Int>()

        for (word in words) {
            val length = word.length
            if (prefixTrie[length] == null) prefixTrie[length] = Trie()
            prefixTrie[length]!!.insert(word)
            if (suffixTrie[length] == null) suffixTrie[length] = Trie()
            suffixTrie[length]!!.insert(word.reversed())
            if (lenMap[length] == null) lenMap[length] = 1
            else lenMap[length] = lenMap[length]!! + 1
        }

        val answer = mutableListOf<Int>()
        for (query in queries) {
            if (query[0] == '?' && query[query.length - 1] == '?') {
                answer.add(lenMap[query.length] ?: 0)
            } else if (query[0] == '?') {
                if (suffixTrie[query.length] != null) {
                    answer.add(suffixTrie[query.length]!!.find(query.reversed()))
                } else {
                    answer.add(0)
                }
            } else if (query[query.length - 1] == '?') {
                if (prefixTrie[query.length] != null) {
                    answer.add(prefixTrie[query.length]!!.find(query))
                } else {
                    answer.add(0)
                }
            }
        }
        return answer.toIntArray()
    }

    data class TrieNode(
            val children: MutableMap<Char, TrieNode> = mutableMapOf(),
            var count: Int = 0
    )

    class Trie {
        private val root = TrieNode()

        fun insert(s: String) {
            var current = root
            for (c in s) {
                ++current.count
                if (current.children[c] == null) {
                    current.children[c] = TrieNode()
                }
                current = current.children[c]!!
            }
        }

        fun find(s: String): Int {
            var current = root
            for (c in s) {
                if (c == '?') return current.count
                if (current.children[c] == null) return 0
                current = current.children[c]!!
            }
            return current.count
        }
    }
}