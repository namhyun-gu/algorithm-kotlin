package io.github.namhyungu.algorithm.programmers.dfs

class TravelRoute {
    val routes = mutableMapOf<Pair<String, String>, Int>()
    val graph = mutableMapOf<String, MutableList<String>>()
    val answer = mutableListOf<String>()

    var ticketSize = 0

    fun solution(tickets: Array<Array<String>>): Array<String> {
        ticketSize = tickets.size
        tickets.forEach { (start, end) ->
            routes[start to end] =
                if (routes.containsKey(start to end)) routes[start to end]!! + 1 else 1
            if (graph.containsKey(start)) {
                graph[start]!!.add(end)
            } else {
                graph[start] = mutableListOf(end)
            }
        }

        graph.forEach { it.value.sort() }

        dfs("ICN")

        return answer.toTypedArray()
    }

    fun dfs(start: String) {
        answer.add(start)

        if (answer.size == ticketSize + 1) return

        if (graph[start] != null) {
            for (end in graph[start]!!) {
                if (routes[start to end] == 0) continue

                routes[start to end] = routes[start to end]!! - 1
                dfs(end)
                if (answer.size == ticketSize + 1) return
                routes[start to end] = routes[start to end]!! + 1
            }
        }
        answer.removeAt(answer.size - 1)
    }
}
