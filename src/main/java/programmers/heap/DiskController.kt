package programmers.heap

import java.util.*

// Reference: https://junboom.tistory.com/24
class DiskController {
    fun solution(jobs: Array<IntArray>): Int {
        val queue = PriorityQueue<IntArray>() { a, b -> a[1].compareTo(b[1]) }
        val sorted = jobs.sortedBy { it[0] }

        var time = 0
        var idx = 0
        var responseTimes = 0

        while (idx < jobs.size || queue.isNotEmpty()) {
            while (idx < jobs.size && sorted[idx][0] <= time)
                queue.offer(sorted[idx++])

            if (queue.isEmpty()) {
                time = sorted[idx][0]
            } else {
                val (start, length) = queue.poll()
                responseTimes += time - start + length
                time += length
            }
        }
        return responseTimes / jobs.size
    }
}