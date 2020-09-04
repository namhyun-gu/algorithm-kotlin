package programmers.heap

import org.junit.Test
import util.shouldBe

class DiskControllerTest {
    val sol = DiskController()

    @Test
    fun `Test example input 1`() {
        val jobs = arrayOf(
                intArrayOf(0, 3),
                intArrayOf(1, 9),
                intArrayOf(2, 6)
        )

        sol.solution(jobs) shouldBe 9
    }

    @Test
    fun `Test example input 2`() {
        val jobs = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(500, 6)
        )

        sol.solution(jobs) shouldBe 3
    }
}