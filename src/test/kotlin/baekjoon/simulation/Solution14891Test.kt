package baekjoon.simulation

import org.junit.Test
import util.SystemIOTest

class Solution14891Test : SystemIOTest() {
    val action: () -> Unit = {
        solution14891(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        val input = """
            10101111
            01111101
            11001110
            00000010
            2
            3 -1
            1 1
        """.trimIndent()

        action at input be "7"
    }

    @Test
    fun `Test example input 2`() {
        val input = """
            11111111
            11111111
            11111111
            11111111
            3
            1 1
            2 1
            3 1
        """.trimIndent()

        action at input be "15"
    }

    @Test
    fun `Test example input 3`() {
        val input = """
            10001011
            10000011
            01011011
            00111101
            5
            1 1
            2 1
            3 1
            4 1
            1 -1
        """.trimIndent()

        action at input be "6"
    }

    @Test
    fun `Test example input 4`() {
        val input = """
            10010011
            01010011
            11100011
            01010101
            8
            1 1
            2 1
            3 1
            4 1
            1 -1
            2 -1
            3 -1
            4 -1
        """.trimIndent()

        action at input be "5"
    }
}