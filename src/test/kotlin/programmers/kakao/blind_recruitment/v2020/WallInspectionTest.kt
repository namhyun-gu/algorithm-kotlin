package programmers.kakao.blind_recruitment.v2020

import org.junit.Test
import util.shouldBe

class WallInspectionTest {
    val solution = WallInspection()

    @Test
    fun `Test example input 1`() {
        solution.solution(12, intArrayOf(1, 5, 6, 10), intArrayOf(1, 2, 3, 4)) shouldBe 2
    }

    @Test
    fun `Test example input 2`() {
        solution.solution(12, intArrayOf(1, 3, 4, 9, 10), intArrayOf(3, 5, 7)) shouldBe 1
    }
}