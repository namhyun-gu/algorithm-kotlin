package misc.data_structure

import java.util.LinkedList


class BinarySearchTree(private var root: Node? = null) {
    data class Node(val data: Int, var left: Node?, var right: Node?) {
        fun isValid(): Boolean {
            var valid = true
            if (left != null && left!!.data > data) {
                valid = false
            }
            if (right != null && right!!.data < data) {
                valid = false
            }
            return valid
        }
    }

    fun insert(data: Int) = insert(Node(data, null, null))

    fun insert(node: Node) {
        if (root == null) {
            root = node
        } else {
            var current = root!!
            var inserted = false
            while (!inserted) {
                if (node.data < current.data) {
                    if (current.left == null) {
                        inserted = true
                        current.left = node
                    } else {
                        current = current.left!!
                    }
                } else {
                    if (current.right == null) {
                        inserted = true
                        current.right = node
                    } else {
                        current = current.right!!
                    }
                }
            }
        }
    }

    fun isValid(): Boolean {
        if (root != null) {
            val queue = LinkedList<Node>()
            queue.add(root!!)

            while (queue.isNotEmpty()) {
                val current = queue.poll()
                println("visit: ${current.data}")
                if (!current.isValid()) return false

                if (current.left != null) {
                    queue.offer(current.left!!)
                }
                if (current.right != null) {
                    queue.offer(current.right!!)
                }
            }
        }
        return true
    }
}

fun main() {
    val tree = BinarySearchTree()
    tree.insert(5)
    tree.insert(3)
    tree.insert(1)
    tree.insert(4)
    tree.insert(6)
    tree.insert(7)
    println(tree.isValid())
}