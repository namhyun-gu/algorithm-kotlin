package io.github.namhyungu.algorithm.programmers.kakao.blind_recruitment.v2019

class FindPathGame {
    data class Node(val value: Int, val x: Int, var left: Node?, var right: Node?)

    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        var root: Node? = null
        nodeinfo
            .mapIndexed { idx, it -> idx + 1 to it }
            .sortedByDescending { it.second[1] }
            .groupBy { it.second[1] }
            .values
            .forEach {
                if (root == null) {
                    val (value, coord) = it.first()
                    root = Node(value, coord[0], null, null)
                } else {
                    it.forEach { info ->
                        val (value, coord) = info
                        var rootNode = root!!
                        while (true) {
                            if (coord[0] < rootNode.x) {
                                if (rootNode.left == null) {
                                    rootNode.left = Node(value, coord[0], null, null)
                                    break
                                } else {
                                    rootNode = rootNode.left!!
                                }
                            } else {
                                if (rootNode.right == null) {
                                    rootNode.right = Node(value, coord[0], null, null)
                                    break
                                } else {
                                    rootNode = rootNode.right!!
                                }
                            }
                        }
                    }
                }
            }

        return arrayOf(preOrder(root!!).toIntArray(), postOrder(root!!).toIntArray())
    }

    fun preOrder(root: Node, result: MutableList<Int> = mutableListOf()): List<Int> {
        result.add(root.value)
        if (root.left != null) preOrder(root.left!!, result)
        if (root.right != null) preOrder(root.right!!, result)
        return result
    }

    fun postOrder(root: Node, result: MutableList<Int> = mutableListOf()): List<Int> {
        if (root.left != null) postOrder(root.left!!, result)
        if (root.right != null) postOrder(root.right!!, result)
        result.add(root.value)
        return result
    }
}
