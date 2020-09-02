package baekjoon.backtracking

import org.junit.Test
import util.SystemIOTest

class Solution15651Test : SystemIOTest() {
    private val action: () -> Unit = {
        Solution15651.main(arrayOf())
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
            1 1
            1 2
            1 3
            1 4
            2 1
            2 2
            2 3
            2 4
            3 1
            3 2
            3 3
            3 4
            4 1
            4 2
            4 3
            4 4
        """.trimIndent(), action)
    }

    @Test
    fun `Test example input 3`() {
        test("3 3", """
            1 1 1
            1 1 2
            1 1 3
            1 2 1
            1 2 2
            1 2 3
            1 3 1
            1 3 2
            1 3 3
            2 1 1
            2 1 2
            2 1 3
            2 2 1
            2 2 2
            2 2 3
            2 3 1
            2 3 2
            2 3 3
            3 1 1
            3 1 2
            3 1 3
            3 2 1
            3 2 2
            3 2 3
            3 3 1
            3 3 2
            3 3 3
        """.trimIndent(), action)
    }
}