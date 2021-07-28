package io.github.namhyungu.algorithm.baekjoon.bfs

import java.util.*

private val moves: Array<(Int) -> Int> = arrayOf({ x -> x + 1 }, { x -> x - 1 }, { x -> x * 2 })

private lateinit var seconds: IntArray

fun solution1697(args: Array<String>) =
    with(Scanner(System.`in`)) {
        val N = nextInt()
        val K = nextInt()
        seconds = IntArray(100001) { -1 }

        bfs(N, K)
        print(seconds[K])
    }

private fun bfs(x: Int, k: Int) {
    val queue = LinkedList<Int>()
    var second = 0
    queue.add(x)
    seconds[x] = 0

    while (queue.isNotEmpty()) {
        val current = queue.pop()
        for (move in moves) {
            val nextX = move(current)
            if (nextX < 0 || nextX > 100000) continue

            if (seconds[nextX] == -1) {
                seconds[nextX] = seconds[current] + 1
                queue.add(nextX)
            }

            if (nextX == k) return
        }
    }
}
