class LinkList{
    var head:Node?=null
    class Node(val value:Int, var next: Node?)

    fun prepend(head:Node?,item:Int):Node {
        val newNode = Node(item, head)
        return newNode
    }

    fun append(head:Node?,item:Int):Node{
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

    fun printLinkedList(head:Node?){
        var currentNode=head
        while (currentNode !=null){
            println("${currentNode.value} ")
            currentNode=currentNode.next
        }
        println()
    }

    fun count(head:Node?):Int{
        var cnt=0
        var currentNode=head
        while (currentNode!=null){
            cnt++
            currentNode=currentNode.next
        }
        return cnt
    }

    fun search(head:Node?,item:Int):Node?{
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
    fun removeNode(head:Node?,item:Int):Node?{
        val node=search(head,item)
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

}

fun main(){
    val list= LinkList()
    //var head: LinkList.Node?
    //var head:LinkList.Node

    val n1=LinkList.Node(10,null)

    list.head=n1
    println("Number of node: ${list.count(list.head)}")

    list.printLinkedList(list.head)

    list.head=list.prepend(list.head,20)
    list.printLinkedList(list.head)

    list.head=list.append(list.head,30)
    list.printLinkedList(list.head)
    println("Number of node: ${list.count(list.head)}")
    val searchResult=list.search(list.head,5)
    if(searchResult==null){
        println("Item not found")
    }else{
        println("Item found in Linked List")
    }
    list.head=list.removeNode(list.head,10)
    list.printLinkedList(list.head)
//    var n2=list.head
//    list.head=list.removeNode(list.head,n2)
//    list.printLinkedList(list.head)
//    n2=list.head
//    list.head=list.removeNode(list.head,n2)
//    list.printLinkedList(list.head)
}





