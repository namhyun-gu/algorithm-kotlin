package programmers.kakao.blind_recruitment.v2020

import org.junit.Assert.assertEquals
import org.junit.Test

class StringCompressionTest {

    private val solution = StringCompression()

    @Test
    fun `Test example input 1`() {
        assertEquals(7, solution.solution("aabbaccc"))
    }

    @Test
    fun `Test example input 2`() {
        assertEquals(9, solution.solution("ababcdcdababcdcd"))
    }

    @Test
    fun `Test example input 3`() {
        assertEquals(8, solution.solution("abcabcdede"))
    }

    @Test
    fun `Test example input 4`() {
        assertEquals(14, solution.solution("abcabcabcabcdededededede"))
    }

    @Test
    fun `Test example input 5`() {
        assertEquals(17, solution.solution("xababcdcdababcdcd"))
    }
}