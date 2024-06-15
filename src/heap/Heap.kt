package heap

fun main() {
    val heap= intArrayOf(0,12,7,19,5,10,17,1,2,3)
    build_max_heap(heap,heap.size)
    heap.forEach {
        print("$it ")
    }
    println()
    heap_sort(heap, heap.size)
    println("after sorting: ")
    heap.forEach {
        print("$it ")
    }
    println()
}

fun build_max_heap(heap:IntArray,heap_size:Int){
    for (i in (heap.size/2) downTo 1){
        maxHeapify(heap,heap_size,i) //because of complete binary tree, we don't need to leaf node to do heapify
    }
}

fun maxHeapify(heap:IntArray,heapSize:Int,rootIndex:Int){
    val l= left(rootIndex)
    val r= right(rootIndex)
    var largest: Int
    if (l<=heapSize-1 && heap[l]>heap[rootIndex]){
        largest=l
    }else{
        largest=rootIndex
    }
    if (r <= heapSize-1 && heap[r]>heap[largest]){
        largest=r
    }
    if (largest!=rootIndex){
        val tmp=heap[rootIndex]
        heap[rootIndex] = heap[largest]
        heap[largest]=tmp
        maxHeapify(heap,heapSize,largest)
    }
}

fun left(rootIndex:Int):Int{
    return rootIndex*2
}

fun right(rootIndex:Int):Int{
    return (rootIndex*2)+1
}

fun parent(child:Int):Int{
    return child/2
}