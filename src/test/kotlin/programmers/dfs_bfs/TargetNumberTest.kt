package programmers.dfs_bfs

import org.junit.Test
import util.shouldBe
import util.toIntArray

class TargetNumberTest {
    val solution = TargetNumber()

    @Test
    fun `Test example input 1`() {
        val numbers = "[1, 1, 1, 1, 1]".toIntArray()
        val target = 3
        solution.solution(numbers.toIntArray(), target) shouldBe 5
    }
}