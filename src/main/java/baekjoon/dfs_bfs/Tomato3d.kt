package baekjoon.dfs_bfs

import java.util.*

private val dirs = arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(-1, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, -1, 0),
        intArrayOf(0, 0, 1),
        intArrayOf(0, 0, -1)
)

private const val TOMATO = 0
private const val RIPE_TOMATO = 1

private data class PointZ(val x: Int, val y: Int, val z: Int)

fun tomato3d(args: Array<String>) = with(Scanner(System.`in`)) {
    val ripeTomato = LinkedList<PointZ>()
    val M = nextInt()
    val N = nextInt()
    val H = nextInt()
    var allTomatoCnt = 0
    val box = Array(H) { h ->
        Array(N) { n ->
            IntArray(M) { m ->
                val tomato = nextInt()
                if (tomato == RIPE_TOMATO) {
                    ripeTomato.add(PointZ(m, n, h))
                    allTomatoCnt++
                } else if (tomato == TOMATO) {
                    allTomatoCnt++
                }
                tomato
            }
        }
    }

    var result = bfs(box, ripeTomato)
    var ripeTomatoCnt = 0
    box.forEach { arrayY ->
        arrayY.forEach { arrayX ->
            arrayX.forEach {
                if (it == RIPE_TOMATO) {
                    ripeTomatoCnt++
                }
            }
        }
    }
    if (allTomatoCnt != ripeTomatoCnt) result = -1
    print(result)
}

private fun bfs(box: Array<Array<IntArray>>, ripeTomato: LinkedList<PointZ>): Int {
    var day = 0
    val width = box[0][0].size
    val height = box[0].size
    val depth = box.size

    var currentRipeTomato = ripeTomato.size
    while (ripeTomato.isNotEmpty()) {
        val current = ripeTomato.pop()
        val (x, y, z) = current

        if (currentRipeTomato == 0) {
            currentRipeTomato = ripeTomato.size
            day++
        } else {
            currentRipeTomato--
        }

        for (dir in dirs) {
            val (dirX, dirY, dirZ) = dir
            val nextX = x + dirX
            val nextY = y + dirY
            val nextZ = z + dirZ

            if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= width || nextY >= height || nextZ >= depth)
                continue

            if (box[nextZ][nextY][nextX] == TOMATO) {
                box[nextZ][nextY][nextX] = RIPE_TOMATO
                ripeTomato.add(PointZ(nextX, nextY, nextZ))
            }
        }
    }
    return day
}