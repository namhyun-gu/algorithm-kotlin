package programmers.kakao.blind_recruitment.v2019

import org.junit.Test
import util.shouldBe

class FailureRateTest {
    val sol = FailureRate()

    @Test
    fun `Test example input 1`() {
        val stages = intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)
        val expected = arrayOf(3, 4, 2, 1, 5)

        sol.solution(5, stages).toTypedArray() shouldBe expected
    }

    @Test
    fun `Test example input 2`() {
        val stages = intArrayOf(4, 4, 4, 4, 4)
        val expected = arrayOf(4, 1, 2, 3)

        sol.solution(4, stages).toTypedArray() shouldBe expected
    }
}