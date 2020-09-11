package programmers.kakao.internship.v2020

import org.junit.Test
import util.shouldBe
import util.toIntArray

class TrackConstructionTest {
    val sol = TrackConstruction()

    @Test
    fun `Test example input 1`() {
        val board = arrayOf(
                "[0,0,0]".toIntArray(),
                "[0,0,0]".toIntArray(),
                "[0,0,0]".toIntArray()
        )
        val expected = 900

        sol.solution(board) shouldBe expected
    }

    @Test
    fun `Test example input 2`() {
        val board = arrayOf(
                "[0,0,0,0,0,0,0,1]".toIntArray(),
                "[0,0,0,0,0,0,0,0]".toIntArray(),
                "[0,0,0,0,0,1,0,0]".toIntArray(),
                "[0,0,0,0,1,0,0,0]".toIntArray(),
                "[0,0,0,1,0,0,0,1]".toIntArray(),
                "[0,0,1,0,0,0,1,0]".toIntArray(),
                "[0,1,0,0,0,1,0,0]".toIntArray(),
                "[1,0,0,0,0,0,0,0]".toIntArray()
        )
        val expected = 3800

        sol.solution(board) shouldBe expected
    }

    @Test
    fun `Test example input 3`() {
        val board = arrayOf(
                "[0,0,1,0]".toIntArray(),
                "[0,0,0,0]".toIntArray(),
                "[0,1,0,1]".toIntArray(),
                "[1,0,0,0]".toIntArray()
        )
        val expected = 2100

        sol.solution(board) shouldBe expected
    }

    @Test
    fun `Test example input 4`() {
        val board = arrayOf(
                "[0,0,0,0,0,0]".toIntArray(),
                "[0,1,1,1,1,0]".toIntArray(),
                "[0,0,1,0,0,0]".toIntArray(),
                "[1,0,0,1,0,1]".toIntArray(),
                "[0,1,0,0,0,1]".toIntArray(),
                "[0,0,0,0,0,0]".toIntArray()
        )
        val expected = 3200

        sol.solution(board) shouldBe expected
    }
}