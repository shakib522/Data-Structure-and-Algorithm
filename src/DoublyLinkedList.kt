class DoublyLinkedList {
    var head: Node? = null

    class Node(val data: Int, var next: Node?, var prev: Node?)

    fun prepend(item: Int) {
        //add value to start in the linked list
        val newNode = Node(item, head, null)
        newNode.next?.prev = newNode
        head = newNode  //reassign head to the first node
        return
    }

    fun appending(item: Int) {
        //add value to the end of the linked list
        val newNode = Node(item, null, null)
        if (head == null) {
            head = newNode //it is the first node.So assign head to the first node
            return
        }
        var currentNode = head
        while (currentNode?.next != null) {
            currentNode = currentNode.next
        }
        currentNode?.next = newNode
        newNode.prev = currentNode
    }

    fun printDoublyLinkedList() {
        var currentNode = head
        while (currentNode != null) {
            println(currentNode.data)
            currentNode = currentNode.next
        }
    }

    fun searchNode(item: Int): Node? {
        var currentNode = head
        while (currentNode != null) {
            if (currentNode.data == item) {
                break
            }
            currentNode = currentNode.next
        }
        return currentNode
    }

    fun removeNode(node: Node) {
        if (node == head) {
            head = node.next
            head?.prev = null
            return
        }
        val previousNode = node.prev
        val nextNode = node.next
        previousNode?.next = nextNode
        nextNode?.prev = previousNode
        return
    }

    fun insertNode(afterWhichItem:Int,itemToBeInserted:Int){
        val newNode = Node(itemToBeInserted,null,null)
        val whichNode=searchNode(afterWhichItem)

        val nextNode = whichNode?.next

        whichNode?.next=newNode
        newNode.prev=whichNode

        newNode.next=nextNode
        nextNode?.prev=newNode

    }

}

fun main() {
    val doublyList = DoublyLinkedList()
    doublyList.prepend(3)
    doublyList.prepend(1)
    doublyList.prepend(5)

    doublyList.printDoublyLinkedList()
    println()

    doublyList.appending(12)
    doublyList.appending(15)

    doublyList.printDoublyLinkedList()

    val searchResult=doublyList.searchNode(12)
    if (searchResult != null) {
        doublyList.removeNode(searchResult)
        println("Item deleted")
    }else{
        println("Item not found")
    }
    println()
    doublyList.printDoublyLinkedList()
    println()
    doublyList.insertNode(1,89)
    doublyList.printDoublyLinkedList()
}