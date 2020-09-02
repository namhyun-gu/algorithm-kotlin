package baekjoon.bruteforce

import org.junit.Assert
import org.junit.Test
import util.SystemIOTest

class BlackJackTest : SystemIOTest() {

    @Test
    fun `Test example input 1`() {
        setInput("""
            5 21
            5 6 7 8 9
        """.trimIndent())
        BlackJack.main(arrayOf())
        Assert.assertEquals("21", output.toString())
    }

    @Test
    fun `Test example input 2`() {
        setInput("""
            10 500
            93 181 245 214 315 36 185 138 216 295
        """.trimIndent())
        BlackJack.main(arrayOf())
        Assert.assertEquals("497", output.toString())
    }
}