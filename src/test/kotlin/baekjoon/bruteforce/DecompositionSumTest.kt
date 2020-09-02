package baekjoon.bruteforce

import org.junit.Assert
import org.junit.Test
import util.SystemIOTest

class DecompositionSumTest : SystemIOTest() {

    @Test
    fun `Test example input 1`() {
        setInput("216")
        DecompositionSum.main(arrayOf())
        Assert.assertEquals("198", output.toString())
    }

    @Test
    fun `Test example input 2`() {
        setInput("256")
        DecompositionSum.main(arrayOf())
        Assert.assertEquals("245", output.toString())
    }

    @Test
    fun `Test example input 3`() {
        setInput("1")
        DecompositionSum.main(arrayOf())
        Assert.assertEquals("0", output.toString())
    }
}