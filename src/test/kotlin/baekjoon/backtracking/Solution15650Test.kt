package baekjoon.backtracking

import org.junit.Test
import util.SystemIOTest

class Solution15650Test : SystemIOTest() {
    private val action: () -> Unit = {
        Solution15650.main(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        test("3 1", """
            1
            2
            3
        """.trimIndent(), action)
    }

    @Test
    fun `Test example input 2`() {
        test("4 2", """
            1 2
            1 3
            1 4
            2 3
            2 4
            3 4
        """.trimIndent(), action)
    }

    @Test
    fun `Test example input 3`() {
        test("4 4", """
            1 2 3 4
        """.trimIndent(), action)
    }
}