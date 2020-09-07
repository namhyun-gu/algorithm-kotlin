package programmers.kakao.blind_recruitment.v2020

import java.util.*

// TODO: 아직 통과하지 않음
// Reference: shorturl.at/gOQVZ
class MoveBlock {
    data class Coords(val x1: Int, val y1: Int, val x2: Int, val y2: Int) {
        fun contains(x: Int, y: Int): Boolean {
            if (x1 == x && y1 == y) return true
            if (x2 == x && y2 == y) return true
            return false
        }
    }

    data class Status(val coords: Coords, val time: Int)

    fun solution(board: Array<IntArray>): Int {
        val padBoard = Array(board.size + 2) { IntArray(board.size + 2) { 1 } }
        repeat(board.size) { col ->
            repeat(board.size) { row ->
                padBoard[col + 1][row + 1] = board[col][row]
            }
        }

        val queue = LinkedList<Status>()
        val visited = mutableListOf<Coords>()

        queue.add(Status(Coords(1, 1, 2, 1), 0))
        visited.add(Coords(1, 1, 2, 1))

        while (queue.isNotEmpty()) {
            val current = queue.pop()
            val time = current.time + 1
            for (move in moveRobot(padBoard, current.coords)) {
                if (move.contains(board.size, board.size)) return time
                if (!visited.contains(move)) {
                    queue.add(Status(move, time))
                    visited.add(move)
                }
            }
        }
        return 0
    }

    fun moveRobot(board: Array<IntArray>, coords: Coords): List<Coords> {
        val moveDirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        val rotates = arrayOf(1, -1)

        val (x1, y1, x2, y2) = coords
        val robots = mutableListOf<Coords>()

        for (dir in moveDirs) {
            val (dx, dy) = dir
            if (board[y1 + dy][x1 + dx] == 0 && board[y2 + dy][x2 + dx] == 0) {
                robots.add(Coords(x1 + dx, y1 + dy, y2 + dy, x2 + dx))
            }
        }

        if (x1 == x2) {
            for (rotate in rotates) {
                if (board[y1][x1 + rotate] == 0 && board[y2][x2 + rotate] == 0) {
                    robots.add(Coords(x1 + rotate, y1, x1, y1))
                    robots.add(Coords(x2 + rotate, y2, x2, y2))
                }
            }
        } else {
            for (rotate in rotates) {
                if (board[y1 + rotate][x1] == 0 && board[y2 + rotate][x2] == 0) {
                    robots.add(Coords(x1, y1, x1, y1 + rotate))
                    robots.add(Coords(x2, y2, x2, y2 + rotate))
                }
            }
        }
        return robots
    }
}
