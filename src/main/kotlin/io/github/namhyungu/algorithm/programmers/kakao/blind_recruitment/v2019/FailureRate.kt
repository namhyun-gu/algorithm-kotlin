package io.github.namhyungu.algorithm.programmers.kakao.blind_recruitment.v2019

class FailureRate {
    fun solution(N: Int, stages: IntArray): IntArray {
        val cleared = IntArray(N + 2)
        val tried = IntArray(N + 2)
        val failure = mutableListOf<Pair<Int, Double>>()

        stages.forEach {
            tried[it]++
            for (i in 1 until it) {
                tried[i]++
                cleared[i]++
            }
        }
        for (idx in 1..N) {
            if (tried[idx] == 0) failure.add(idx to 0.0)
            else failure.add(idx to ((tried[idx] - cleared[idx]) / tried[idx].toDouble()))
        }

        return failure
            .sortedWith(
                Comparator { o1, o2 ->
                    if (o1.second == o2.second) o1.first.compareTo(o2.first)
                    else o2.second.compareTo(o1.second)
                }
            )
            .map { it.first }
            .toIntArray()
    }
}
