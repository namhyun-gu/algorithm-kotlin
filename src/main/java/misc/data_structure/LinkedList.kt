package misc.data_structure


class LinkedList(private val head: Node = Node(-1, null)) {
    data class Node(val data: Int, var next: Node? = null)

    fun insert(node: Node) {
        var current = head
        while (current.next != null) {
            current = current.next!!
        }
        current.next = node
    }

    fun delete() {
        var current = head
        while (current.next != null && current.next!!.next != null) {
            current = current.next!!
        }
        current.next = null
    }

    fun search(data: Int): Boolean {
        var current = head
        while (current.next != null) {
            if (current.data == data) return true
            current = current.next!!
        }
        return current.data == data
    }

    fun asString(): String {
        val list = mutableListOf<Int>()
        var current = head
        while (current.next != null) {
            if (current.data != -1) {
                list.add(current.data)
            }
            current = current.next!!
        }
        return list.joinToString()
    }
}

fun main() {
    val linkedList = LinkedList()
    linkedList.insert(LinkedList.Node(1))
    linkedList.insert(LinkedList.Node(2))
    linkedList.insert(LinkedList.Node(3))
    linkedList.insert(LinkedList.Node(4))

    println(linkedList.asString())
    linkedList.delete()

    println(linkedList.search(4))
    println(linkedList.search(3))
    println(linkedList.asString())
}