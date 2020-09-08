package programmers.kakao.blind_recruitment.v2019

import org.junit.Test
import util.shouldBe

class CandidateKeyTest {
    val sol = CandidateKey()

    @Test
    fun `Test example input 1`() {
        val relation = arrayOf(
                arrayOf("100", "ryan", "music", "2"),
                arrayOf("200", "apeach", "math", "2"),
                arrayOf("300", "tube", "computer", "3"),
                arrayOf("400", "con", "computer", "4"),
                arrayOf("500", "muzi", "music", "3"),
                arrayOf("600", "apeach", "music", "2")
        )

        sol.solution(relation) shouldBe 2
    }
}