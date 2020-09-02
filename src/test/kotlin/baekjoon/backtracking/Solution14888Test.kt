package baekjoon.backtracking

import org.junit.Test
import util.SystemIOTest

class Solution14888Test : SystemIOTest() {

    val action: () -> Unit = {
        Solution14888.main(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        test("""
            2
            5 6
            0 0 1 0
        """.trimIndent(), """
            30
            30
        """.trimIndent(), action)
    }

    @Test
    fun `Test example input 2`() {
        test("""
            3
            3 4 5
            1 0 1 0
        """.trimIndent(), """
            35
            17
        """.trimIndent(), action)
    }

    @Test
    fun `Test example input 3`() {
        test("""
            6
            1 2 3 4 5 6
            2 1 1 1
        """.trimIndent(), """
            54
            -24
        """.trimIndent(), action)
    }
}