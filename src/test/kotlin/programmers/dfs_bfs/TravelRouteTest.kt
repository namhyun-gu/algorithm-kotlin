package programmers.dfs_bfs

import org.junit.Test
import util.shouldBe

class TravelRouteTest {
    val solution = TravelRoute()

    @Test
    fun `Test example input 1`() {
        val tickets = arrayOf(
                arrayOf("ICN", "JFK"),
                arrayOf("HND", "IAD"),
                arrayOf("JFK", "HND")
        )
        val expected = arrayOf("ICN", "JFK", "HND", "IAD")

        solution.solution(tickets) shouldBe expected
    }

    @Test
    fun `Test example input 2`() {
        val tickets = arrayOf(
                arrayOf("ICN", "SFO"),
                arrayOf("ICN", "ATL"),
                arrayOf("SFO", "ATL"),
                arrayOf("ATL", "ICN"),
                arrayOf("ATL", "SFO"),
        )
        val expected = arrayOf("ICN", "ATL", "ICN", "SFO", "ATL", "SFO")

        solution.solution(tickets) shouldBe expected
    }

    @Test
    fun `Test example input 3`() {
        val tickets = arrayOf(
                arrayOf("ICN", "A"),
                arrayOf("ICN", "B"),
                arrayOf("B", "ICN")
        )
        val expected = arrayOf("ICN", "B", "ICN", "A")

        solution.solution(tickets) shouldBe expected
    }

    @Test
    fun `Test example input 4`() {
        val tickets = arrayOf(
                arrayOf("ICN", "A"),
                arrayOf("A", "B"),
                arrayOf("B", "A"),
                arrayOf("A", "ICN"),
                arrayOf("ICN", "A")
        )
        val expected = arrayOf("ICN", "A", "B", "A", "ICN", "A")

        solution.solution(tickets) shouldBe expected
    }

    @Test
    fun `Test example input 5`() {
        val tickets = arrayOf(
                arrayOf("ICN", "A"),
                arrayOf("A", "C"),
                arrayOf("A", "D"),
                arrayOf("D", "B"),
                arrayOf("B", "A")
        )
        val expected = arrayOf("ICN", "A", "D", "B", "A", "C")

        solution.solution(tickets) shouldBe expected
    }
}