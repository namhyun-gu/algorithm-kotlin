package baekjoon.simulation

import java.util.*

fun solution2947(args: Array<String>) = with(Scanner(System.`in`)) {
    val woods = IntArray(5) { nextInt() }
    while (!isCorrectOrder(woods)) {
        for (idx in 0..3) {
            if (woods[idx] > woods[idx + 1]) {
                val temp = woods[idx]
                woods[idx] = woods[idx + 1]
                woods[idx + 1] = temp
                println(String.format("%d %d %d %d %d", woods[0], woods[1], woods[2], woods[3], woods[4]))
            }
        }
    }
}

fun isCorrectOrder(woods: IntArray): Boolean {
    repeat(5) { if (woods[it] != it + 1) return false }
    return true
}