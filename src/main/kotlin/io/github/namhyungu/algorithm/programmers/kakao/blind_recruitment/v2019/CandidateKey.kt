package io.github.namhyungu.algorithm.programmers.kakao.blind_recruitment.v2019

// Reference: http://shorturl.at/fgS57
class CandidateKey {
    val uniqueKeys = mutableListOf<HashSet<Int>>()

    fun solution(relation: Array<Array<String>>): Int {
        dfs(relation, HashSet(), 0)
        return uniqueKeys.size
    }

    fun dfs(relation: Array<Array<String>>, selects: HashSet<Int>, depth: Int) {
        if (depth == relation[0].size) {
            uniqueKeys.forEach { if (selects.containsAll(it)) return }

            if (!isUnique(relation, selects.toIntArray())) {
                return
            }

            uniqueKeys.add(selects)
            return
        }

        val set1 = HashSet<Int>()
        val set2 = HashSet<Int>()

        selects.forEach {
            set1.add(it)
            set2.add(it)
        }

        dfs(relation, set1, depth + 1)
        set2.add(depth)
        dfs(relation, set2, depth + 1)
    }

    fun isUnique(relation: Array<Array<String>>, columns: IntArray): Boolean {
        val tuples = relation.map { columns.map { col -> it[col] }.toTypedArray() }
        for (i in tuples.indices) {
            for (j in tuples.indices) {
                if (i != j && tuples[i].contentEquals(tuples[j])) {
                    return false
                }
            }
        }
        return true
    }
}
