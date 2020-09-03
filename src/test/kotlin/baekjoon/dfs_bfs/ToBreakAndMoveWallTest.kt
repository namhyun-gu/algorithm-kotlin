package baekjoon.dfs_bfs

import org.junit.Test
import util.SystemIOTest

class ToBreakAndMoveWallTest : SystemIOTest() {
    val action: () -> Unit = {
        toBreakAndMoveWall(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        val input = """
            6 4
            0100
            1110
            1000
            0000
            0111
            0000
        """.trimIndent()

        action at input be "15"
    }

    @Test
    fun `Test example input 2`() {
        val input = """
            4 4
            0111
            1111
            1111
            1110
        """.trimIndent()

        action at input be "-1"
    }

    @Test
    fun `Test example input 3`() {
        val input = """
            1 1
            0
        """.trimIndent()

        action at input be "1"
    }
}