package baekjoon.greedy

import org.junit.Test
import util.SystemIOTest

class Solution11047Test : SystemIOTest() {

    val action: () -> Unit = {
        Solution11047.main(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        test(
                """
            10 4200
            1
            5
            10
            50
            100
            500
            1000
            5000
            10000
            50000
        """.trimIndent(), "6", action
        )
    }

    @Test
    fun `Test example input 2`() {
        test(
                """
            10 4790
            1
            5
            10
            50
            100
            500
            1000
            5000
            10000
            50000
        """.trimIndent(), "12", action
        )
    }
}