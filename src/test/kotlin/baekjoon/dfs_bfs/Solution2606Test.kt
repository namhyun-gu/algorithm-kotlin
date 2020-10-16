package baekjoon.dfs_bfs

import org.junit.Test
import util.SystemIOTest

class Solution2606Test : SystemIOTest() {
    val action: () -> Unit = {
        solution2606(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        val input = """
            7
            6
            1 2
            2 3
            1 5
            5 2
            5 6
            4 7
        """.trimIndent()

        action at input be "4"
    }

    @Test
    fun `Test example input 2`() {
        val input = """
            7
            6
            2 1
            2 3
            5 1
            5 2
            5 6
            4 7
        """.trimIndent()

        action at input be "4"
    }
}