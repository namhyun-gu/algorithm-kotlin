package baekjoon.simulation

import org.junit.Test
import util.SystemIOTest

class Solution2947Test : SystemIOTest() {
    val action: () -> Unit = {
        solution2947(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        val input = "2 1 5 3 4"
        val expected = """
            1 2 5 3 4
            1 2 3 5 4
            1 2 3 4 5
        """.trimIndent()

        action at input be expected
    }
}