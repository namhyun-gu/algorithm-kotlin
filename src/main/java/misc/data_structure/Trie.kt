package misc.data_structure


data class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var isEndOfWord: Boolean = false
)

class Trie {
    private val root = TrieNode()

    fun insert(s: String) {
        var current = root
        for (c in s) {
            if (current.children[c] == null) {
                current.children[c] = TrieNode()
            }
            current = current.children[c]!!
        }
        current.isEndOfWord = true
    }

    fun find(s: String): Boolean {
        var current = root
        for (c in s) {
            if (current.children[c] == null) return false
            current = current.children[c]!!
        }
        return current.isEndOfWord
    }
}
