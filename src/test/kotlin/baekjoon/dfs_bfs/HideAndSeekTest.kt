package baekjoon.dfs_bfs

import org.junit.Test
import util.SystemIOTest

class HideAndSeekTest : SystemIOTest() {
    val action: () -> Unit = {
        hideAndSeek(arrayOf())
    }

    @Test
    fun `Test example input 1`() {
        action at "5 17" be "4"
    }

    @Test
    fun `Test example input 2`() {
        action at "5 0" be "5"
    }

    @Test
    fun `Test example input 3`() {
        action at "50000 99999" be "2"
    }
}