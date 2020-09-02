package baekjoon.backtracking

import org.junit.Test
import util.SystemIOTest

class Solution14889Test : SystemIOTest() {
    val action: () -> Unit = {
        Solution14889.main(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        test("""
            4
            0 1 2 3
            4 0 5 6
            7 1 0 2
            3 4 5 0
        """.trimIndent(), "0", action)
    }

    @Test
    fun `Test example input 2`() {
        test("""
            6
            0 1 2 3 4 5
            1 0 2 3 4 5
            1 2 0 3 4 5
            1 2 3 0 4 5
            1 2 3 4 0 5
            1 2 3 4 5 0
        """.trimIndent(), "2", action)
    }

    @Test
    fun `Test example input 3`() {
        test("""
            8
            0 5 4 5 4 5 4 5
            4 0 5 1 2 3 4 5
            9 8 0 1 2 3 1 2
            9 9 9 0 9 9 9 9
            1 1 1 1 0 1 1 1
            8 7 6 5 4 0 3 2
            9 1 9 1 9 1 0 9
            6 5 4 3 2 1 9 0
        """.trimIndent(), "1", action)
    }
}