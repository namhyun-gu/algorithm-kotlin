package programmers.kakao.blind_recruitment.v2018

import org.junit.Assert.assertEquals
import org.junit.Test

class NewsClusteringTest {
    val solution = NewsClustering()

    @Test
    fun `Test example input 1`() {
        assertEquals(16384, solution.solution("FRANCE", "french"))
    }

    @Test
    fun `Test example input 2`() {
        assertEquals(65536, solution.solution("handshake", "shake hands"))
    }

    @Test
    fun `Test example input 3`() {
        assertEquals(43690, solution.solution("aa1+aa2", "AAAA12"))
    }

    @Test
    fun `Test example input 4`() {
        assertEquals(65536, solution.solution("E=M*C^2", "e=m*c^2"))
    }
}