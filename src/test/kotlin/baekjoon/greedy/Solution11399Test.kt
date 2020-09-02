package baekjoon.greedy

import org.junit.Test
import util.SystemIOTest

class Solution11399Test : SystemIOTest() {
    val action: () -> Unit = {
        solution11399(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        test("""
            5
            3 1 4 3 2
        """.trimIndent(), "32", action)
    }
}