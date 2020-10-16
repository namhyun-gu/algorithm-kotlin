package baekjoon.dfs_bfs

import java.util.*

private val dirs = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
)

data class Status(val x: Int, val y: Int, val canBreak: Boolean, val count: Int)

fun solution2206(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt()
    val map = Array(N) { next().toCharArray() }

    print(bfs(map, N, M))
}

private fun bfs(map: Array<CharArray>, N: Int, M: Int): Int {
    val visited = Array(N) {
        Array(M) {
            BooleanArray(2)
        }
    }

    val queue = LinkedList<Status>()
    queue.add(Status(0, 0, true, 1))

    visited[0][0][0] = true
    visited[0][0][1] = true

    while (queue.isNotEmpty()) {
        val (x, y, canBreak, count) = queue.pop()

        if (x == M - 1 && y == N - 1) {
            return count
        }

        for (dir in dirs) {
            val (dirX, dirY) = dir
            val nextX = x + dirX
            val nextY = y + dirY

            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
                continue

            val wasBreak = if (canBreak) 0 else 1

            if (map[nextY][nextX] == '1') {
                if (canBreak && !visited[nextY][nextX][1]) {
                    visited[nextY][nextX][1] = true
                    queue.add(Status(nextX, nextY, false, count + 1))
                }
            } else {
                if (!visited[nextY][nextX][wasBreak]) {
                    visited[nextY][nextX][wasBreak] = true
                    queue.add(Status(nextX, nextY, canBreak, count + 1))
                }
            }
        }
    }
    return -1
}