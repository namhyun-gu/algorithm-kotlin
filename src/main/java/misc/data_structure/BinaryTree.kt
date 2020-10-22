package misc.data_structure

import java.util.LinkedList

class BinaryTree(private var root: Node? = null) {
    data class Node(val data: Int, var left: Node?, var right: Node?)

    fun insert(data: Int) = insert(Node(data, null, null))

    // Insert level-order
    fun insert(node: Node) {
        if (root == null) {
            root = node
        } else {
            val queue = LinkedList<Node>()
            queue.offer(root!!)

            while (queue.isNotEmpty()) {
                val current = queue.poll()
                if (current.left != null) {
                    queue.offer(current.left!!)
                } else {
                    current.left = node
                    break
                }
                if (current.right != null) {
                    queue.offer(current.right!!)
                } else {
                    current.right = node
                    break
                }
            }
        }
    }

    fun print() {
        val queue = LinkedList<Pair<Node, Int>>()
        if (root != null) {
            queue.add(root!! to 1)

            while (queue.isNotEmpty()) {
                val current = queue.poll()
                val (node, depth) = current

                println("node: ${node.data}, depth: $depth")

                if (node.left != null) {
                    queue.offer(node.left!! to depth + 1)
                }
                if (node.right != null) {
                    queue.offer(node.right!! to depth + 1)
                }
            }
        }
    }
}

fun main() {
    val tree = BinaryTree()
    repeat(7) {
        tree.insert(it)
    }
    tree.print()
}