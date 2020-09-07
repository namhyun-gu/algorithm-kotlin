package programmers.kakao.blind_recruitment.v2020

import org.junit.Assert.assertEquals
import org.junit.Test

class LockAndKeyTest {

    val solution = LockAndKey()

    @Test
    fun `Test example input 1`() {
        assertEquals(true, solution.solution(
                arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(1, 0, 0),
                        intArrayOf(0, 1, 1)
                ),
                arrayOf(
                        intArrayOf(1, 1, 1),
                        intArrayOf(1, 1, 0),
                        intArrayOf(1, 0, 1)
                )
        ))
    }
}