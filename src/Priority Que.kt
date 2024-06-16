import heap.maxHeapify
import heap.parent


fun main() {

}

class PriorityQue(var size:Int) {
    fun extractMax(heap: IntArray): Int {
        //time complexity of this function: O(log n)
        val maxItem = heap[1]
        heap[1] = heap[size]
        maxHeapify(heap, size - 1, 1)
        size--
        return maxItem
    }

    fun insertNode(heap: IntArray, node: Int): Int {
        //time complexity of this function: O (log n)
        size++
        heap[size] = node
        var i = size
        while (i > 1 && heap[i] > heap[parent(i)]) {
            val p = parent(i)
            val tmp = heap[p]
            heap[p] = heap[i]
            heap[i] = tmp
            i = p
        }
        return size
    }

}
