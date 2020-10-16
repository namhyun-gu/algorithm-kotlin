package baekjoon.dfs_bfs

import java.util.*

private data class Point(val x: Int, val y: Int)

private val dirs = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
)

fun solution1012(args: Array<String>) = with(Scanner(System.`in`)) {
    val T = nextInt()
    repeat(T) {
        val M = nextInt()
        val N = nextInt()
        val K = nextInt()

        val graph = Array(N) {
            BooleanArray(M)
        }

        val plants = LinkedList<Point>()
        repeat(K) {
            val x = nextInt()
            val y = nextInt()

            plants.add(Point(x, y))
            graph[y][x] = true
        }

        println(bfs(graph, plants))
    }
}

private fun bfs(graph: Array<BooleanArray>, plants: LinkedList<Point>): Int {
    var worms = 0
    val worm = Array(graph.size) { IntArray(graph[0].size) }
    val queue = LinkedList<Point>()

    while (plants.isNotEmpty()) {
        val current = plants.pop()
        val (curX, curY) = current

        if (worm[curY][curX] > 0) continue

        worms++
        queue.add(current)
        while (queue.isNotEmpty()) {
            val (x, y) = queue.pop()
            worm[y][x] = worms

            for (i in dirs.indices) {
                val nextX = x + dirs[i][0]
                val nextY = y + dirs[i][1]

                if (nextX < 0 || nextY < 0 || nextX >= graph[0].size || nextY >= graph.size) {
                    continue
                }

                if (graph[nextY][nextX] && worm[nextY][nextX] == 0) {
                    worm[nextY][nextX] = worms
                    queue.add(Point(nextX, nextY))
                }
            }
        }
    }
    return worms
}