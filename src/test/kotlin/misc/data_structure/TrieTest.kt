package misc.data_structure

import org.junit.Test
import util.shouldBe

class TrieTest {

    @Test
    fun `Test insert and find`() {
        val words = arrayOf("frodo", "front", "frost", "frozen", "frame", "kakao")
        val trie = Trie()

        for (word in words) {
            trie.insert(word)
        }

        for (word in words) {
            trie.find(word) shouldBe true
        }
    }
}