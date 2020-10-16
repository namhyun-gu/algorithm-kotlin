package baekjoon.priority_queue

import java.util.*

fun solution11279(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt()
    val queue = PriorityQueue<Int>(N) { o1, o2 -> o2.compareTo(o1) }
    repeat(N) {
        val x = nextInt()
        if (x == 0) {
            println(if (queue.isEmpty()) 0 else queue.poll())
        } else queue.offer(x)
    }
}