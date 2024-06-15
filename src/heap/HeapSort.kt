package heap

fun heap_sort(heap:IntArray,heap_size:Int){
    var siz=heap_size
    for(i in heap_size-1 downTo 2){
        val t=heap[1]
        heap[1]=heap[i]
        heap[i]=t
        siz--
        maxHeapify(heap,siz,1)
    }
}