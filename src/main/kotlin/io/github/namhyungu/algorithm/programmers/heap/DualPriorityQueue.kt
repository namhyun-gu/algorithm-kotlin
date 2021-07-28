package io.github.namhyungu.algorithm.programmers.heap

import java.util.*

class DualPriorityQueue {
    fun solution(operations: Array<String>): IntArray {
        val minQueue = PriorityQueue<Int>()
        val maxQueue = PriorityQueue<Int>(reverseOrder())

        operations.map { it.split(" ") }.forEach { (operation, valueStr) ->
            val value = Integer.parseInt(valueStr)
            if (operation == "I") {
                minQueue.offer(value)
                maxQueue.offer(value)
            } else {
                if (minQueue.isNotEmpty() && maxQueue.isNotEmpty()) {
                    if (value == 1) {
                        val max = maxQueue.poll()
                        minQueue.remove(max)
                    } else {
                        val min = minQueue.poll()
                        maxQueue.remove(min)
                    }
                }
            }
        }

        return if (minQueue.isEmpty()) intArrayOf(0, 0)
        else intArrayOf(maxQueue.poll(), minQueue.poll())
    }
}
