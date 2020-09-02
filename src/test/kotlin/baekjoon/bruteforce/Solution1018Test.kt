package baekjoon.bruteforce

import org.junit.Assert
import org.junit.Test
import util.SystemIOTest

class Solution1018Test : SystemIOTest() {
    @Test
    fun `Test example input 1`() {
        setInput("""
            8 8
            WBWBWBWB
            BWBWBWBW
            WBWBWBWB
            BWBBBWBW
            WBWBWBWB
            BWBWBWBW
            WBWBWBWB
            BWBWBWBW
        """.trimIndent())
        Solution1018.main(arrayOf())
        Assert.assertEquals("1", output.toString())
    }

    @Test
    fun `Test example input 2`() {
        setInput("""
            10 13
            BBBBBBBBWBWBW
            BBBBBBBBBWBWB
            BBBBBBBBWBWBW
            BBBBBBBBBWBWB
            BBBBBBBBWBWBW
            BBBBBBBBBWBWB
            BBBBBBBBWBWBW
            BBBBBBBBBWBWB
            WWWWWWWWWWBWB
            WWWWWWWWWWBWB
        """.trimIndent())
        Solution1018.main(arrayOf())
        Assert.assertEquals("12", output.toString())
    }
}