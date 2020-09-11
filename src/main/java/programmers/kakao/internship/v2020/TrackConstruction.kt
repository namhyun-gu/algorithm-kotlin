package programmers.kakao.internship.v2020

import java.util.*
import kotlin.math.min

// Reference: https://tech.kakao.com/2020/07/01/2020-internship-test/
class TrackConstruction {
    enum class Dir { Left, Right, Top, Bottom }

    data class Status(val x: Int, val y: Int, val dir: Dir, val cost: Int)

    data class Direction(val dx: Int, val dy: Int, val dir: Dir)

    val dirs = arrayOf(
            Direction(1, 0, Dir.Right),
            Direction(-1, 0, Dir.Left),
            Direction(0, 1, Dir.Top),
            Direction(0, -1, Dir.Bottom)
    )

    fun solution(board: Array<IntArray>): Int {
        val r = bfs(board, Dir.Right)
        val b = bfs(board, Dir.Bottom)
        return min(r, b)
    }

    fun bfs(board: Array<IntArray>, startDir: Dir): Int {
        val costs = Array(board.size) { IntArray(board.size) }
        val queue = LinkedList<Status>()

        queue.add(Status(0, 0, startDir, 0))
        costs[0][0] = 1

        var minCost = Int.MAX_VALUE
        while (queue.isNotEmpty()) {
            val (x, y, dir, cost) = queue.pop()

            if (x == board.size - 1 && y == board.size - 1) {
                minCost = min(minCost, cost)
            }

            for ((dx, dy, nextDir) in dirs) {
                if (x + dx < 0 || y + dy < 0 || x + dx >= board.size || y + dy >= board.size) continue

                val newCost = if (isStraight(dir, nextDir)) cost + 100 else cost + 600

                if (board[y + dy][x + dx] == 0) {
                    if ((costs[y + dy][x + dx] == 0 || costs[y + dy][x + dx] > newCost)) {
                        costs[y + dy][x + dx] = newCost
                        queue.add(Status(x + dx, y + dy, nextDir, newCost))
                    }
                }
            }
        }
        return minCost
    }

    fun isStraight(currentDir: Dir, nextDir: Dir): Boolean {
        if ((currentDir == Dir.Right || currentDir == Dir.Left) &&
                (nextDir == Dir.Left || nextDir == Dir.Right)) {
            return true
        } else if ((currentDir == Dir.Top || currentDir == Dir.Bottom) &&
                (nextDir == Dir.Top || nextDir == Dir.Bottom)) {
            return true
        } else if ((currentDir == Dir.Right || currentDir == Dir.Left) &&
                (nextDir == Dir.Bottom || nextDir == Dir.Top)) {
            return false
        } else if (((currentDir == Dir.Bottom || currentDir == Dir.Top)) &&
                (nextDir == Dir.Right || nextDir == Dir.Left)) {
            return false
        }
        return false
    }
}