package misc.algorithm

fun IntArray.swap(a: Int, b: Int) {
    val temp = this[a]
    this[a] = this[b]
    this[b] = temp
}

// Space Complexity : O(1)
// Time Complexity : O(n^2)
fun bubbleSort(array: IntArray): IntArray {
    for (i in 0 until array.size - 1) {
        for (j in i + 1 until array.size) {
            if (array[i] > array[j]) {
                array.swap(i, j)
            }
        }
    }
    return array
}

// Space Complexity : O(1)
// Time Complexity : O(n^2)
fun selectionSort(array: IntArray): IntArray {
    for (i in 0 until array.size - 1) {
        var maxIdx = i
        for (j in i + 1 until array.size) {
            if (array[maxIdx] > array[j]) {
                maxIdx = j
            }
        }
        array.swap(maxIdx, i)
    }
    return array
}

// Space Complexity : O(1)
// Time Complexity : O(n^2)
fun insertionSort(array: IntArray): IntArray {
    for (i in 1 until array.size) {
        val temp = array[i]
        var j = i - 1
        while (j >= 0) {
            if (temp >= array[j]) break
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = temp
    }
    return array
}

// Space Complexity : O(n)
// Time Complexity : O(nlogn)
fun mergeSort(array: IntArray): IntArray {
    divide(array, 0, array.size)
    return array
}

fun divide(array: IntArray, start: Int, end: Int) {
    if (end - start < 2) return

    val mid = (start + end) / 2
    divide(array, 0, mid)
    divide(array, mid, end)
    conquer(array, start, mid, end)
}

fun conquer(array: IntArray, start: Int, mid: Int, end: Int) {
    val temp = IntArray(end - start)
    var idx = 0
    var left = start
    var right = mid

    while (left < mid && right < end) {
        if (array[left] < array[right]) {
            temp[idx++] = array[left++]
        } else {
            temp[idx++] = array[right++]
        }
    }

    while (left < mid) {
        temp[idx++] = array[left++]
    }

    while (right < end) {
        temp[idx++] = array[right++]
    }

    for (i in start until end) {
        array[i] = temp[i - start]
    }
}

// Space Complexity : O(log(n))
// Time Complexity : O(nlogn)
fun quickSort(array: IntArray): IntArray {
    internalQuickSort(array, 0, array.size - 1)
    return array
}

fun internalQuickSort(array: IntArray, start: Int, end: Int) {
    if (start < end) {
        val mid = (start + end) / 2
        val pivot = array[mid]
        var i = start
        var j = end

        while (i < j) { // Partition
            while (array[j] > pivot) j--
            while (i < j && array[i] < pivot) i++
            array.swap(i, j)
        }
        internalQuickSort(array, start, i - 1)
        internalQuickSort(array, i + 1, end)
    }
}

// Space Complexity : O(n)
// Time Complexity : O(n)
fun radixSort(array: IntArray): IntArray {
    val temp = IntArray(100)
    val result = IntArray(array.size)

    array.forEach {
        temp[it] = it
    }
    var idx = 0
    temp.forEach {
        if (it != 0) {
            result[idx++] = it
        }
    }
    return result
}

fun main() {
    val bubbleSort = bubbleSort(intArrayOf(2, 1, 4, 0, 3))
    println("bubbleSort: ${bubbleSort.joinToString()}")

    val selectionSort = selectionSort(intArrayOf(2, 1, 4, 0, 3))
    println("selectionSort: ${selectionSort.joinToString()}")

    val insertionSort = insertionSort(intArrayOf(2, 1, 4, 0, 3))
    println("insertionSort: ${insertionSort.joinToString()}")

    val mergeSort = mergeSort(intArrayOf(2, 1, 4, 0, 3))
    println("mergeSort: ${mergeSort.joinToString()}")

    val quickSort = quickSort(intArrayOf(2, 1, 4, 0, 3))
    println("quickSort: ${quickSort.joinToString()}")

    val radixSort = radixSort(intArrayOf(52, 31, 24, 45, 13))
    println("radixSort: ${radixSort.joinToString()}")
}