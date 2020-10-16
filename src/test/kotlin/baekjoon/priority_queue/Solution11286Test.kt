package baekjoon.priority_queue

import org.junit.Test
import util.SystemIOTest

class Solution11286Test : SystemIOTest() {
    val action: () -> Unit = {
        solution11286(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        val input = """
            18
            1
            -1
            0
            0
            0
            1
            1
            -1
            -1
            2
            -2
            0
            0
            0
            0
            0
            0
            0
        """.trimIndent()

        val expected = """
            -1
            1
            0
            -1
            -1
            1
            1
            -2
            2
            0
        """.trimIndent()

        action at input be expected
    }
}