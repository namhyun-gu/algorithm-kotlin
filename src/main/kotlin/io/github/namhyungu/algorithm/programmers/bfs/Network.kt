package io.github.namhyungu.algorithm.programmers.bfs

import java.util.*

class Network {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var cnt = 0
        val queue = LinkedList<Int>()
        val network = IntArray(n)
        for (i in 0 until n) {
            if (network[i] == 0) {
                network[i] = ++cnt
                queue.add(i)
            }
            while (queue.isNotEmpty()) {
                val current = queue.pop()
                for (next in 0 until n) {
                    if (current != next && computers[current][next] == 1 && network[next] == 0) {
                        network[next] = cnt
                        queue.add(next)
                    }
                }
            }
        }
        return cnt
    }
}
