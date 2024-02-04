class Que(private val size: Int) {
    private val data = IntArray(size + 1)
    var head = 0
    var tail = 0
    fun enqueue(que: Que, item: Int) {
        if ((que.tail + 1) % (que.size + 1) == que.head) {
            println("Queue is full")
            return
        }
        que.data[que.tail] = item
        que.tail = (que.tail + 1) % (que.size + 1)
    }

    fun dequeue(que: Que): Int {
        if (que.tail == que.head) {
            println("Queue is empty")
            return -1
        }
        val item = que.data[que.head]
        que.head = (que.head + 1) % (que.size + 1)
        return item
    }
}

fun main(){
    val que=Que(5)
    que.dequeue(que)
    println("tail: ${que.tail}")
    que.enqueue(que,5)
    println("tail: ${que.tail}")
    que.enqueue(que,2)
    println("tail: ${que.tail}")
    que.enqueue(que,15)
    println("tail: ${que.tail}")
    que.enqueue(que,6)
    println("tail: ${que.tail}")
    que.enqueue(que,23)
    println("tail: ${que.tail}")
    que.enqueue(que,4)
    println("tail: ${que.tail}")

    println("Beginning head: ${que.head}")
    println("item : ${que.dequeue(que)} , head: ${que.head}")
    println("item : ${que.dequeue(que)} , head: ${que.head}")
    println("item : ${que.dequeue(que)} , head: ${que.head}")
    println("item : ${que.dequeue(que)} , head: ${que.head}")
    println("item : ${que.dequeue(que)} , head: ${que.head}")
    println("item : ${que.dequeue(que)} , head: ${que.head}")
}