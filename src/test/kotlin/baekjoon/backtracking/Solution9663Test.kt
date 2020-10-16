package baekjoon.backtracking

import org.junit.Test
import util.SystemIOTest

class Solution9663Test : SystemIOTest() {
    val action: () -> Unit = {
        Solution9663.main(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        test("8", "92", action)
    }
}