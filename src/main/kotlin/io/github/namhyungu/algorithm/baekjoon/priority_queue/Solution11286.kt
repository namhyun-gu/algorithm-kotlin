package io.github.namhyungu.algorithm.baekjoon.priority_queue

import java.util.*
import kotlin.math.abs

fun solution11286(args: Array<String>) =
    with(Scanner(System.`in`)) {
        val N = nextInt()
        val queue =
            PriorityQueue<Int>(N) { o1, o2 ->
                if (abs(o1) == abs(o2)) o1.compareTo(o2) else abs(o1).compareTo(abs(o2))
            }
        repeat(N) {
            val x = nextInt()
            if (x == 0) {
                println(if (queue.isEmpty()) 0 else queue.poll())
            } else queue.offer(x)
        }
    }
