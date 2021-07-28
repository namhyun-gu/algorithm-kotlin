package io.github.namhyungu.algorithm.baekjoon.priority_queue

import java.util.*

// Reference: https://blog.naver.com/PostView.nhn?blogId=pasdfq&logNo=221205694882
fun solution1655(args: Array<String>) =
    with(Scanner(System.`in`)) {
        val N = nextInt()
        val minHeap = PriorityQueue<Int>(N)
        val maxHeap = PriorityQueue<Int>(N, reverseOrder())
        repeat(N) {
            val n = nextInt()

            if (maxHeap.size > minHeap.size) minHeap.offer(n) else maxHeap.offer(n)

            if (minHeap.isNotEmpty() && maxHeap.isNotEmpty() && minHeap.peek() < maxHeap.peek()) {
                val min = minHeap.poll()
                val max = maxHeap.poll()
                minHeap.offer(max)
                maxHeap.offer(min)
            }
            println(maxHeap.peek())
        }
    }
