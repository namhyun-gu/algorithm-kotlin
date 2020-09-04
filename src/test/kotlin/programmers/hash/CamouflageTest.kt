package programmers.hash

import org.junit.Test
import util.shouldBe

class CamouflageTest {
    val solution = Camouflage()

    @Test
    fun `Test example input 1`() {
        val clothes = arrayOf(
                arrayOf("yellow_hat", "headgear"),
                arrayOf("blue_sunglasses", "eyewear"),
                arrayOf("green_turban", "headgear")
        )

        solution.solution(clothes) shouldBe 5
    }

    @Test
    fun `Test example input 2`() {
        val clothes = arrayOf(
                arrayOf("crow_mask", "face"),
                arrayOf("blue_sunglasses", "face"),
                arrayOf("smoky_makeup", "face")
        )

        solution.solution(clothes) shouldBe 3
    }
}