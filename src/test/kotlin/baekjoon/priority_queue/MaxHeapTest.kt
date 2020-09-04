package baekjoon.priority_queue

import org.junit.Test
import util.SystemIOTest

class MaxHeapTest : SystemIOTest() {
    val action: () -> Unit = {
        maxHeap(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        val input = """
            13
            0
            1
            2
            0
            0
            3
            2
            1
            0
            0
            0
            0
            0
        """.trimIndent()

        val expected = """
            0
            2
            1
            3
            2
            1
            0
            0
        """.trimIndent()

        action at input be expected
    }
}