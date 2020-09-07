package programmers.kakao.blind_recruitment.v2020

// Reference: https://leveloper.tistory.com/101
class WallInspection {
    lateinit var picked: IntArray
    lateinit var weaks: Array<IntArray>

    var finish = false
    var count = 0

    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        weaks = Array(weak.size) {
            moveWeak(n, weak, it)
        }

        for (i in 1..dist.size) {
            count = i
            picked = IntArray(dist.size)
            permutation(dist, BooleanArray(dist.size), 0)
            if (finish) break
        }
        return if (finish) count else -1
    }

    fun moveWeak(n: Int, weak: IntArray, i: Int): IntArray {
        val moved = IntArray(weak.size)
        for (idx in weak.indices) {
            moved[idx] = if (idx + i < weak.size) weak[idx + i]
            else weak[idx + i - weak.size] + n
        }
        return moved
    }

    fun permutation(array: IntArray, visit: BooleanArray, depth: Int) {
        if (finish) return

        if (depth == array.size) {
            inspect()
            return
        }

        for (i in array.indices) {
            if (!visit[i]) {
                visit[i] = true
                picked[depth] = array[i]
                permutation(array, visit, depth + 1)
                visit[i] = false
            }
        }
    }

    fun inspect() {
        for (weak in weaks) {
            val visit = BooleanArray(weak.size)
            var idx = 0
            var start = 0

            while (idx != count) {
                var i = start
                val current = picked[idx++]
                for (j in start until weak.size) {
                    if (weak[i] <= weak[j] && weak[j] <= weak[i] + current) {
                        visit[j] = true
                        start++
                    } else {
                        break
                    }
                }
                if (isFinish(visit)) {
                    finish = true
                    return
                }
            }
        }
    }

    fun isFinish(visit: BooleanArray): Boolean {
        visit.forEach { if (!it) return false }
        return true
    }
}