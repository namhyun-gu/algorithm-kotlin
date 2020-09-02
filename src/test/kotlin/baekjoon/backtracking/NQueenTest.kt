package baekjoon.backtracking

import org.junit.Test
import util.SystemIOTest

class NQueenTest : SystemIOTest() {
    val action: () -> Unit = {
        NQueen.main(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        test("8", "92", action)
    }
}