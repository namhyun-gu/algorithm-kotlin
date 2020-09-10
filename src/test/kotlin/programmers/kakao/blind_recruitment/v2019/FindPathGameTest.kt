package programmers.kakao.blind_recruitment.v2019

import org.junit.Test
import util.shouldBe

class FindPathGameTest {
    val sol = FindPathGame()

    @Test
    fun `Test example input 1`() {
        val nodeInfo = arrayOf(
                intArrayOf(5, 3),
                intArrayOf(11, 5),
                intArrayOf(13, 3),
                intArrayOf(3, 5),
                intArrayOf(6, 1),
                intArrayOf(1, 3),
                intArrayOf(8, 6),
                intArrayOf(7, 2),
                intArrayOf(2, 2)
        )

        val expected = arrayOf(
                intArrayOf(7, 4, 6, 9, 1, 8, 5, 2, 3),
                intArrayOf(9, 6, 5, 8, 1, 4, 3, 2, 7)
        )

        sol.solution(nodeInfo) shouldBe expected
    }
}