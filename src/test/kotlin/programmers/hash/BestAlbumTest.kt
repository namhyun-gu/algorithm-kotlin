package programmers.hash

import org.junit.Test
import util.shouldBe

class BestAlbumTest {
    val solution = BestAlbum()

    @Test
    fun `Test example input 1`() {
        val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
        val plays = intArrayOf(500, 600, 150, 800, 2500)
        val expected = arrayOf(4, 1, 3, 0)

        solution.solution(genres, plays).toTypedArray() shouldBe expected
    }
}