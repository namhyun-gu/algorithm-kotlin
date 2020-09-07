package programmers.kakao.blind_recruitment.v2020

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class InstallPillarAndBeamTest {
    val solution = InstallPillarAndBeam()

    @Test
    fun `Test example input 1`() {
        val expected = arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(1, 1, 1),
                intArrayOf(2, 1, 0),
                intArrayOf(2, 2, 1),
                intArrayOf(3, 2, 1),
                intArrayOf(4, 2, 1),
                intArrayOf(5, 0, 0),
                intArrayOf(5, 1, 0)
        )

        val buildFrame = arrayOf(
                intArrayOf(1, 0, 0, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(2, 1, 0, 1),
                intArrayOf(2, 2, 1, 1),
                intArrayOf(5, 0, 0, 1),
                intArrayOf(5, 1, 0, 1),
                intArrayOf(4, 2, 1, 1),
                intArrayOf(3, 2, 1, 1)
        )
        assertArrayEquals(expected, solution.solution(5, buildFrame))
    }

    @Test
    fun `Test example input 2`() {
        val expected = arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 1),
                intArrayOf(1, 1, 1),
                intArrayOf(2, 1, 1),
                intArrayOf(3, 1, 1),
                intArrayOf(4, 0, 0)
        )

        val buildFrame = arrayOf(
                intArrayOf(0, 0, 0, 1),
                intArrayOf(2, 0, 0, 1),
                intArrayOf(4, 0, 0, 1),
                intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(2, 1, 1, 1),
                intArrayOf(3, 1, 1, 1),
                intArrayOf(2, 0, 0, 0),
                intArrayOf(1, 1, 1, 0),
                intArrayOf(2, 2, 0, 1)
        )
        assertArrayEquals(expected, solution.solution(5, buildFrame))
    }
}