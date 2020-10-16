package baekjoon.dfs_bfs

import org.junit.Test
import util.SystemIOTest

class Solution1012Test : SystemIOTest() {
    val action: () -> Unit = {
        solution1012(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        val input = """
            2
            10 8 17
            0 0
            1 0
            1 1
            4 2
            4 3
            4 5
            2 4
            3 4
            7 4
            8 4
            9 4
            7 5
            8 5
            9 5
            7 6
            8 6
            9 6
            10 10 1
            5 5
        """.trimIndent()

        val expected = """
            5
            1
        """.trimIndent()

        action at input be expected
    }

    @Test
    fun `Test example input 2`() {
        val input = """
            1
            5 3 6
            0 2
            1 2
            2 2
            3 2
            4 2
            4 0
        """.trimIndent()

        action at input be "2"
    }
}