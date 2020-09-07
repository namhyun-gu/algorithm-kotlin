package programmers.kakao.blind_recruitment.v2020

import org.junit.Test
import util.shouldBe

class SearchLyricsTest {
    val sol = SearchLyrics()

    @Test
    fun `Test example input 1`() {
        val words = arrayOf("frodo", "front", "frost", "frozen", "frame", "kakao")
        val queries = arrayOf("fro??", "????o", "fr???", "fro???", "pro?")
        val expected = arrayOf(3, 2, 4, 1, 0)

        sol.solution(words, queries).toTypedArray() shouldBe expected
    }
}