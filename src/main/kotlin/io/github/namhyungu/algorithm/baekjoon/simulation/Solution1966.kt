package io.github.namhyungu.algorithm.baekjoon.simulation

import java.util.*

fun solution1966(args: Array<String>) =
    with(Scanner(System.`in`)) {
        val T = nextInt()
        repeat(T) {
            val N = nextInt()
            val M = nextInt()
            val queue = LinkedList<Pair<Int, Int>>()

            repeat(N) {
                val importance = nextInt()
                queue.add(it to importance)
            }

            var cnt = 0
            while (queue.isNotEmpty()) {
                val (idx, importance) = queue.pop()
                val isPrint = queue.filter { importance < it.second }.isEmpty()
                if (!isPrint) {
                    queue.add(idx to importance)
                } else {
                    ++cnt
                    if (idx == M) {
                        println(cnt)
                        break
                    }
                }
            }
        }
    }
