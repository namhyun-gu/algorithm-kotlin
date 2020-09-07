package programmers.kakao.blind_recruitment.v2020

import org.junit.Assert.assertEquals
import org.junit.Test

class ParenthesisTransformationTest {

    val solution = ParenthesisTransformation()

    @Test
    fun `Test example input 1`() {
        assertEquals("(()())()", solution.solution("(()())()"))
    }

    @Test
    fun `Test example input 2`() {
        assertEquals("()", solution.solution(")("))
    }

    @Test
    fun `Test example input 3`() {
        assertEquals("()(())()", solution.solution("()))((()"))
    }
}