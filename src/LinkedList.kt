class LinkList{
    var head:Node?=null
    class Node(val value:Int, var next: Node?)

    fun prepend(item:Int):Node {
        val newNode = Node(item, head)
        return newNode
    }

    fun append(item:Int):Node?{
        val newNode=Node(item,null)
        if(head==null){
            return newNode
        }
        var currentNode=head
        while (currentNode?.next!=null){
            currentNode=currentNode.next
        }
        currentNode?.next=newNode
        return head
    }
    fun reverseList(){
        var currentNode = head
        var prev : Node? = null
        while (currentNode!=null){
           val temp = currentNode.next
            currentNode.next=prev
            prev=currentNode
            currentNode=temp
        }
        head=prev
    }

    fun printLinkedList(){
        var currentNode=head
        while (currentNode !=null){
            println("${currentNode.value} ")
            currentNode=currentNode.next
        }
        println()
    }

    fun count():Int{
        var cnt=0
        var currentNode=head
        while (currentNode!=null){
            cnt++
            currentNode=currentNode.next
        }
        return cnt
    }

    fun search(item:Int):Node?{
        var currentNode=head
        var ans:Node?=null
        while (currentNode!=null){
            if (currentNode.value==item){
                ans=currentNode
                break
            }
            currentNode=currentNode.next
        }
        return ans
    }
    fun removeNode(item:Int):Node?{
        val node=search(item)
        val newHead: Node?
        if(node==head){
            newHead = node?.next
            return newHead
        }
        var currentNode=head
        while(currentNode != null){
            if(currentNode.next==node){
                break
            }
            currentNode=currentNode.next
        }
        if(currentNode == null){
            return head
        }

        currentNode.next=node?.next
        return head
    }

    fun insert(nodeValueAfterNewNumberAdded:Int,itemToBeInserted:Int){
        val node=search(nodeValueAfterNewNumberAdded)
        val newNode=Node(itemToBeInserted,node?.next)
        node?.next=newNode
    }

}

fun main(){
    val list= LinkList()

    val n1=LinkList.Node(10,null)

    list.head=n1
    println("Number of node: ${list.count()}")

    list.printLinkedList()

    list.head=list.prepend(20)
    list.printLinkedList()

    list.head=list.append(30)
    list.printLinkedList()
    println("Number of node: ${list.count()}")
    val searchResult=list.search(5)
    if(searchResult==null){
        println("Item not found")
    }else{
        println("Item found in Linked List")
    }
    list.head=list.removeNode(10)
    list.printLinkedList()

    list.head=list.append(90)
    list.insert(20,45)
    list.insert(20,19)
    list.printLinkedList()
    println("last inserted")
    list.insert(45,169)
    list.printLinkedList()

    println("reverse list")
    list.reverseList()
    list.printLinkedList()
}





