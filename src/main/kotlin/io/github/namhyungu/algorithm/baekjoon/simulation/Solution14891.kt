package io.github.namhyungu.algorithm.baekjoon.simulation

import java.util.*
import kotlin.math.pow

val wheels = Array(4) { "" }

fun solution14891(args: Array<String>) =
    with(Scanner(System.`in`)) {
        repeat(4) { wheels[it] = nextLine() }

        val K = nextInt()
        repeat(K) {
            val num = nextInt() - 1
            val isClockDir = (nextInt() == 1)
            val rotated = mutableListOf<Pair<Int, Boolean>>()

            rotated.add(num to isClockDir)

            var idx = 1
            var temp = !isClockDir
            while (true) {
                if (canRotate(num - idx, true)) {
                    rotated.add(num - idx to temp)
                } else {
                    break
                }
                temp = !temp
                idx++
            }

            idx = 1
            temp = !isClockDir
            while (true) {
                if (canRotate(num + idx, false)) {
                    rotated.add(num + idx to temp)
                } else {
                    break
                }
                temp = !temp
                idx++
            }

            rotated.forEach { wheels[it.first] = wheels[it.first].rotateWheel(it.second) }
        }

        val score =
            wheels.foldIndexed(0) { index, acc, s ->
                acc + if (s[0] == '1') 2.0.pow(index.toDouble()).toInt() else 0
            }
        println(score)
    }

fun canRotate(num: Int, left: Boolean): Boolean {
    if (num < 0 || num > 3) return false
    return if (left) {
        wheels[num][2] != wheels[num + 1][6]
    } else {
        wheels[num][6] != wheels[num - 1][2]
    }
}

fun String.rotateWheel(clockDir: Boolean): String {
    return if (clockDir) {
        this[7] + substring(0, 7)
    } else {
        substring(1, 8) + this[0]
    }
}
