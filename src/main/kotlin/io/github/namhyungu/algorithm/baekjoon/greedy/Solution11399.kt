package io.github.namhyungu.algorithm.baekjoon.greedy

import java.util.*

fun solution11399(args: Array<String>) =
    with(Scanner(System.`in`)) {
        val N = nextInt()
        val mans = Array(N) { nextInt() }
        Arrays.sort(mans)
        print(sumTimes(mans))
    }

fun sumTimes(array: Array<Int>): Int {
    var times = 0
    for (i in array.indices) {
        var time = array[i]
        for (j in 0 until i) {
            time += array[j]
        }
        times += time
    }
    return times
}
