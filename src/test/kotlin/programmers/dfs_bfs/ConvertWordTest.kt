package programmers.dfs_bfs

import org.junit.Test
import util.shouldBe

class ConvertWordTest {
    val solution = ConvertWord()

    @Test
    fun `Test example input 1`() {
        val begin = "hit"
        val target = "cog"
        val words = arrayOf("hot", "dot", "dog", "lot", "log", "cog")

        solution.solution(begin, target, words) shouldBe 4
    }

    @Test
    fun `Test example input 2`() {
        val begin = "hit"
        val target = "cog"
        val words = arrayOf("hot", "dot", "dog", "lot", "log")

        solution.solution(begin, target, words) shouldBe 0
    }
}