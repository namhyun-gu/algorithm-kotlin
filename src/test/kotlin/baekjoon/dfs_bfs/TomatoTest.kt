package baekjoon.dfs_bfs

import org.junit.Test
import util.SystemIOTest

class TomatoTest : SystemIOTest() {
    val action: () -> Unit = {
        tomato(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        val input = """
            6 4
            0 0 0 0 0 0
            0 0 0 0 0 0
            0 0 0 0 0 0
            0 0 0 0 0 1
        """.trimIndent()

        action at input be "8"
    }

    @Test
    fun `Test example input 2`() {
        val input = """
            6 4
            0 -1 0 0 0 0
            -1 0 0 0 0 0
            0 0 0 0 0 0
            0 0 0 0 0 1
        """.trimIndent()

        action at input be "-1"
    }

    @Test
    fun `Test example input 3`() {
        val input = """
            6 4
            1 -1 0 0 0 0
            0 -1 0 0 0 0
            0 0 0 0 -1 0
            0 0 0 0 -1 1
        """.trimIndent()

        action at input be "6"
    }

    @Test
    fun `Test example input 4`() {
        val input = """
            5 5
            -1 1 0 0 0
            0 -1 -1 -1 0
            0 -1 -1 -1 0
            0 -1 -1 -1 0
            0 0 0 0 0
        """.trimIndent()

        action at input be "14"
    }

    @Test
    fun `Test example input 5`() {
        val input = """
            2 2
            1 -1
            -1 1
        """.trimIndent()

        action at input be "0"
    }
}