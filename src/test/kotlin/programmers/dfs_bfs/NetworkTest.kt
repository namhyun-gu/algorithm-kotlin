package programmers.dfs_bfs

import org.junit.Test
import util.shouldBe

class NetworkTest {
    val solution = Network()

    @Test
    fun `Test example input 1`() {
        val n = 3
        val computers = arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 0, 1)
        )
        solution.solution(n, computers) shouldBe 2
    }

    @Test
    fun `Test example input 2`() {
        val n = 3
        val computers = arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 1),
                intArrayOf(0, 1, 1)
        )
        solution.solution(n, computers) shouldBe 1
    }
}