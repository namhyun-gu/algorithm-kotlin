package programmers.kakao.blind_recruitment.v2020

import org.junit.Test
import util.shouldBe

class MoveBlockTest {

    val solution = MoveBlock()

    @Test
    fun `Test example input 1`() {
        val board = arrayOf(
                intArrayOf(0, 0, 0, 1, 1),
                intArrayOf(0, 0, 0, 1, 0),
                intArrayOf(0, 1, 0, 1, 1),
                intArrayOf(1, 1, 0, 0, 1),
                intArrayOf(0, 0, 0, 0, 0)
        )

        solution.solution(board) shouldBe 7
    }
}