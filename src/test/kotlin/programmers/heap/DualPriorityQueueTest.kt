package programmers.heap

import org.junit.Test
import util.SystemIOTest
import util.shouldBe

class DualPriorityQueueTest : SystemIOTest() {
    val sol = DualPriorityQueue()

    @Test
    fun `Test example input 1`() {
        val input = arrayOf("I 16", "D 1")
        val expected = arrayOf(0, 0)

        sol.solution(input).toTypedArray() shouldBe expected
    }

    @Test
    fun `Test example input 2`() {
        val input = arrayOf("I 7", "I 5", "I -5", "D -1")
        val expected = arrayOf(7, 5)

        sol.solution(input).toTypedArray() shouldBe expected
    }
}