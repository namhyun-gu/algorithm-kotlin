package baekjoon.bruteforce

import org.junit.Assert
import org.junit.Test
import util.SystemIOTest

class Solution7568Test : SystemIOTest() {
    @Test
    fun `Test example input 1`() {
        setInput("""
            5
            55 185
            58 183
            88 186
            60 175
            46 155
        """.trimIndent())
        Solution7568.main(arrayOf())
        Assert.assertEquals("2 2 1 2 5 ", output.toString())
    }
}