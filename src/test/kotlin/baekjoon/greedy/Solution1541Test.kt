package baekjoon.greedy

import org.junit.Test
import util.SystemIOTest

class Solution1541Test : SystemIOTest() {
    val action: () -> Unit = {
        solution1541(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        test("55-50+40", "-35", action)
    }
}