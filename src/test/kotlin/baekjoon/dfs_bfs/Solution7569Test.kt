package baekjoon.dfs_bfs

import org.junit.Test
import util.SystemIOTest

class Solution7569Test : SystemIOTest() {
    val action: () -> Unit = {
        solution7569(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        val input = """
            5 3 1
            0 -1 0 0 0
            -1 -1 0 1 1
            0 0 0 1 1
        """.trimIndent()

        action at input be "-1"
    }

    @Test
    fun `Test example input 2`() {
        val input = """
            5 3 2
            0 0 0 0 0
            0 0 0 0 0
            0 0 0 0 0
            0 0 0 0 0
            0 0 1 0 0
            0 0 0 0 0
        """.trimIndent()

        action at input be "4"
    }

    @Test
    fun `Test example input 3`() {
        val input = """
            4 3 2
            1 1 1 1
            1 1 1 1
            1 1 1 1
            1 1 1 1
            -1 -1 -1 -1
            1 1 1 -1
        """.trimIndent()

        action at input be "0"
    }
}