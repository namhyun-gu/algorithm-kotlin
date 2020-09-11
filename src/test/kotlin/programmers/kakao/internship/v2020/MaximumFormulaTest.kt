package programmers.kakao.internship.v2020

import org.junit.Test
import util.shouldBe

class MaximumFormulaTest {
    val sol = MaximumFormula()

    @Test
    fun `Test example input 1`() {
        val expression = "100-200*300-500+20"
        val expected: Long = 60420

        sol.solution(expression) shouldBe expected
    }

    @Test
    fun `Test example input 2`() {
        val expression = "50*6-3*2"
        val expected: Long = 300

        sol.solution(expression) shouldBe expected
    }
}