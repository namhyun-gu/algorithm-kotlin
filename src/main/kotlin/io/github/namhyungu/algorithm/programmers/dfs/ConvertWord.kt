package io.github.namhyungu.algorithm.programmers.dfs

class ConvertWord {
    lateinit var visited: BooleanArray

    var convertCnt = Int.MAX_VALUE

    fun solution(begin: String, target: String, words: Array<String>): Int {
        if (!words.contains(target)) {
            return 0
        }

        visited = BooleanArray(words.size)
        dfs(0, begin, target, words)
        return convertCnt
    }

    fun dfs(depth: Int, current: String, target: String, words: Array<String>) {
        if (current == target) {
            convertCnt = Math.min(convertCnt, depth)
            return
        }
        if (depth == words.size - 1) {
            return
        }
        for (i in words.indices) {
            val next = words[i]
            if (!visited[i] && current.diff(next) == 1) {
                visited[i] = true
                dfs(depth + 1, next, target, words)
                visited[i] = false
            }
        }
    }

    fun String.diff(b: String): Int {
        var diff = 0
        forEachIndexed { index, c ->
            if (c != b[index]) {
                diff++
            }
        }
        return diff
    }
}
