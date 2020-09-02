package baekjoon.bruteforce

import org.junit.Test
import util.SystemIOTest

class Solution1436Test : SystemIOTest() {

    private val action: () -> Unit = {
        Solution1436.main(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        test("2", "1666", action)
    }

    @Test
    fun `Test example input 2`() {
        test("1", "666", action)
    }

    @Test
    fun `Test example input 3`() {
        test("7", "6660", action)
    }

    @Test
    fun `Test example input 4`() {
        test("5000", "1466659", action)
    }
}