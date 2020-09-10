package programmers.kakao.internship.v2020

import org.junit.Test
import util.shouldBe

class PressKeypadTest {
    val sol = PressKeypad()

    @Test
    fun `Test example input 1`() {
        val numbers = intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5)
        val hand = "right"
        val expected = "LRLLLRLLRRL"

        sol.solution(numbers, hand) shouldBe expected
    }

    @Test
    fun `Test example input 2`() {
        val numbers = intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2)
        val hand = "left"
        val expected = "LRLLRRLLLRR"

        sol.solution(numbers, hand) shouldBe expected
    }

    @Test
    fun `Test example input 3`() {
        val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        val hand = "right"
        val expected = "LLRLLRLLRL"

        sol.solution(numbers, hand) shouldBe expected
    }
}