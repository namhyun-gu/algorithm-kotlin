package io.github.namhyungu.algorithm.baekjoon.bfs

import java.util.*

fun solution2606(args: Array<String>) =
    with(Scanner(System.`in`)) {
        val n = nextInt()
        val pairSize = nextInt()
        val graph = Array(n + 1) { BooleanArray(n + 1) }
        repeat(pairSize) {
            val start = nextInt()
            val end = nextInt()
            graph[start][end] = true
            graph[end][start] = true
        }
        print(bfs(graph))
    }

fun bfs(graph: Array<BooleanArray>): Int {
    var count = 0
    val queue = LinkedList<Int>()
    val visit = BooleanArray(graph.size)

    queue.add(1)
    while (!queue.isEmpty()) {
        val current = queue.pop()
        visit[current] = true

        for (i in 1 until graph.size) {
            if (graph[current][i] && !visit[i]) {
                count++
                visit[i] = true
                queue.add(i)
            }
        }
    }
    return count
}
