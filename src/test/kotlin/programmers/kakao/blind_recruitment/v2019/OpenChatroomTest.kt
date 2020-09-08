package programmers.kakao.blind_recruitment.v2019

import org.junit.Test
import util.shouldBe

class OpenChatroomTest {
    val sol = OpenChatroom()

    @Test
    fun `Test example input 1`() {
        val record = arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan")
        val expected = arrayOf("Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다.")

        sol.solution(record) shouldBe expected
    }
}