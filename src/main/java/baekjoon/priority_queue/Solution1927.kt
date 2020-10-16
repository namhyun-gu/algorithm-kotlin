package baekjoon.priority_queue

import java.util.*

fun solution1927(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt()
    val queue = PriorityQueue<Int>(N)
    repeat(N) {
        val x = nextInt()
        if (x == 0) {
            println(if (queue.isEmpty()) 0 else queue.poll())
        } else queue.offer(x)
    }
}