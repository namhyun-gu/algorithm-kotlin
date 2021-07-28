package io.github.namhyungu.algorithm.programmers.kakao.blind_recruitment.v2019

class OpenChatroom {
    enum class Event {
        Enter,
        Leave,
        Change,
        None
    }

    val usernames = mutableMapOf<String, String>()

    fun solution(record: Array<String>): Array<String> =
        record
            .map { it.toEvent() }
            .filter { it.first != Event.Change }
            .map { toEventString(it) }
            .toTypedArray()

    fun toEventString(event: Pair<Event, String>): String {
        return "${usernames[event.second]}님이 ${if (event.first == Event.Enter) "들어왔습니다." else "나갔습니다."}"
    }

    fun String.toEvent() =
        when {
            this.startsWith("Enter") -> {
                val (_, uid, name) = this.split(" ")
                usernames[uid] = name
                Event.Enter to uid
            }
            this.startsWith("Change") -> {
                val (_, uid, name) = this.split(" ")
                usernames[uid] = name
                Event.Change to uid
            }
            this.startsWith("Leave") -> {
                val (_, uid) = this.split(" ")
                Event.Leave to uid
            }
            else -> Event.None to ""
        }
}
