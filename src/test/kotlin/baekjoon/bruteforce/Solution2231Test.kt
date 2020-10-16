package baekjoon.bruteforce

import org.junit.Assert
import org.junit.Test
import util.SystemIOTest

class Solution2231Test : SystemIOTest() {

    @Test
    fun `Test example input 1`() {
        setInput("216")
        Solution2231.main(arrayOf())
        Assert.assertEquals("198", output.toString())
    }

    @Test
    fun `Test example input 2`() {
        setInput("256")
        Solution2231.main(arrayOf())
        Assert.assertEquals("245", output.toString())
    }

    @Test
    fun `Test example input 3`() {
        setInput("1")
        Solution2231.main(arrayOf())
        Assert.assertEquals("0", output.toString())
    }
}