package io.github.namhyungu.algorithm.baekjoon.greedy

import java.util.*
import kotlin.math.max

fun solution1931(args: Array<String>) =
    with(Scanner(System.`in`)) {
        val n = nextInt()
        var maxEnd = 0
        val conference =
            Array(n) {
                val start = nextInt()
                val end = nextInt()
                maxEnd = max(maxEnd, end)
                intArrayOf(start, end)
            }

        Arrays.sort(conference) { o1, o2 ->
            if (o1[1] == o2[1]) o1[0].compareTo(o2[0]) else o1[1].compareTo(o2[1])
        }

        var count = 1
        var end = conference[0][1]
        for (i in 1 until conference.size) {
            if (conference[i][0] >= end) {
                end = conference[i][1]
                count++
            }
        }
        print(count)
    }
