package baekjoon.simulation

import org.junit.Test
import util.SystemIOTest

class PrinterQueueTest : SystemIOTest() {
    val action: () -> Unit = {
        printerQueue(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        val input = """
            3
            1 0
            5
            4 2
            1 2 3 4
            6 0
            1 1 9 1 1 1
        """.trimIndent()

        val expected = """
            1
            2
            5
        """.trimIndent()

        action at input be expected
    }
}