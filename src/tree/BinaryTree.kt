package tree

class Node(val data:Int,var left:Node?=null,var right:Node?=null)

fun addLeftChild(node:Node?,child:Node?){
    node?.left=child
}

fun addRightChild(node:Node?,child:Node?){
    node?.right=child
}
fun preOrder(node:Node?) {
    print("${node?.data} ")
    if (node?.left!=null){
        preOrder(node.left)
    }
    if (node?.right!=null){
        preOrder(node.right)
    }
}
fun createTree():Node{
    val two=Node(2)
    val seven=Node(7)
    val nine=Node(9)
    addLeftChild(two,seven)
    addRightChild(two,nine)
    val one=Node(1)
    val six=Node(6)
    addLeftChild(seven,one)
    addRightChild(seven,six)

    val eight=Node(8)
    addRightChild(nine,eight)
    val five=Node(5)
    val ten=Node(10)
    addLeftChild(six,five)
    addRightChild(six,ten)
    val three=Node(3)
    val four=Node(4)
    addLeftChild(eight,three)
    addRightChild(eight,four)
    return two
}
fun main() {
    val root= createTree()
    println(root.data)
    preOrder(root)
}