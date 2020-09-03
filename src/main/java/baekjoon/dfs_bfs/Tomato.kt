package baekjoon.dfs_bfs

import java.util.*

private val dirs = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1)
)

private const val TOMATO = 0
private const val RIPE_TOMATO = 1

fun tomato(args: Array<String>) = with(Scanner(System.`in`)) {
    val ripeTomato = LinkedList<Pair<Int, Int>>()
    val M = nextInt()
    val N = nextInt()
    var allTomatoCnt = 0
    val box = Array(N) { n ->
        IntArray(M) { m ->
            val tomato = nextInt()
            if (tomato == RIPE_TOMATO) {
                ripeTomato.add(Pair(m, n))
                allTomatoCnt++
            } else if (tomato == TOMATO) {
                allTomatoCnt++
            }
            tomato
        }
    }

    var result = bfs(box, ripeTomato)
    var ripeTomatoCnt = 0
    box.forEach {
        it.forEach {
            if (it == RIPE_TOMATO) {
                ripeTomatoCnt++
            }
        }
    }
    if (allTomatoCnt != ripeTomatoCnt) result = -1
    print(result)
}

private fun bfs(box: Array<IntArray>, ripeTomato: LinkedList<Pair<Int, Int>>): Int {
    var day = 0
    val width = box[0].size
    val height = box.size

    var currentRipeTomato = ripeTomato.size
    while (ripeTomato.isNotEmpty()) {
        val current = ripeTomato.pop()
        val (x, y) = current

        if (currentRipeTomato == 0) {
            currentRipeTomato = ripeTomato.size
            day++
        } else {
            currentRipeTomato--
        }

        for (dir in dirs) {
            val (dirX, dirY) = dir
            val nextX = x + dirX
            val nextY = y + dirY

            if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height)
                continue

            if (box[nextY][nextX] == TOMATO) {
                box[nextY][nextX] = RIPE_TOMATO
                ripeTomato.add(Pair(nextX, nextY))
            }
        }
    }
    return day
}