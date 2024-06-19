import heap.maxHeapify
import heap.parent
import java.util.*
import kotlin.Comparator


fun main() {
    val pq = PriorityQueue<Int>()
    pq.add(3)
    pq.add(12)
    pq.add(8)
    pq.add(1)
    pq.add(100)
    pq.add(11)
    pq.add(2)
    println(pq)
    println(pq.poll())
    println(pq.poll())
    //the all integer value are inserted using min heap.That's why we get value according to min heap when we print the priority queue
    val comparator = Comparator<Pair<Int,Int>>{ p1,p2 ->
        p1.second-p2.second
    }
    val pq2=PriorityQueue(comparator)
    pq2.add(Pair(3,2))
    pq2.add(Pair(4,1))
    println(pq2.peek())
}

class PriorityQue(var size: Int) {
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
