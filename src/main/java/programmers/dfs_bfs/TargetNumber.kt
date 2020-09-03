package programmers.dfs_bfs

class TargetNumber {
    var count = 0

    fun solution(numbers: IntArray, target: Int): Int {
        createTargetNumber(numbers, 0, 0, target)
        return count
    }

    fun createTargetNumber(numbers: IntArray, depth: Int, sum: Int, target: Int) {
        if (depth == numbers.size) {
            if (sum == target) {
                count++
            }
            return
        }

        createTargetNumber(numbers, depth + 1, sum + numbers[depth], target)
        createTargetNumber(numbers, depth + 1, sum - numbers[depth], target)
    }
}