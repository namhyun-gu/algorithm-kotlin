package baekjoon.greedy

import org.junit.Test
import util.SystemIOTest

class Solution1931Test : SystemIOTest() {

    val action: () -> Unit = {
        solution1931(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        test("""
            11
            1 4
            3 5
            0 6
            5 7
            3 8
            5 9
            6 10
            8 11
            8 12
            2 13
            12 14
        """.trimIndent(), "4", action
        )
    }

    @Test
    fun `Test example input 2`() {
        test("""
            9 
            8 8 
            5 8
            3 4
            2 5 
            2 7
            8 8
            1 10
            3 3
            10 10
        """.trimIndent(), "6", action)
    }
}