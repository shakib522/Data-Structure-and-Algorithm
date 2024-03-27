package tree

class BstNode(val data:Int, var parent:BstNode?=null, var left:BstNode?=null, var right:BstNode?=null){

    fun addLeftChild(node:BstNode?,child:BstNode?){
        node?.left=child
        if(child!=null){
            child.parent=node
        }
    }
    fun addRightChild(node:BstNode?,child:BstNode?){
        node?.right=child
        if(child!=null){
            child.parent=node
        }
    }
    fun preOrder(root:BstNode?){
        print("${root?.data} ")
        if (root?.left!=null){
            preOrder(root.left)
        }
        if (root?.right!=null){
            preOrder(root.right)
        }
    }
    fun inOrder(root:BstNode?){
        if (root?.left!=null){
            inOrder(root.left)
        }
        print("${root?.data} ")
        if (root?.right!=null){
            inOrder(root.right)
        }
    }
    fun postOrder(root:BstNode?){
        if (root?.left!=null){
            postOrder(root.left)
        }
        if (root?.right!=null){
            postOrder(root.right)
        }
        print("${root?.data} ")
    }
    fun bstInsert(root:BstNode?,node:BstNode): BstNode {
        var parentNode:BstNode
        var currentNode:BstNode?
        if (root==null){
            return node
        }
        currentNode=root
        parentNode=currentNode
        while (currentNode!=null){
            parentNode=currentNode
            if (currentNode.data<node.data){
                currentNode=currentNode.right
            }else{
                currentNode=currentNode.left
            }
        }

        if (parentNode.data > node.data){
            addLeftChild(parentNode,node)
        }else{
            addRightChild(parentNode,node)
        }
        return root
    }
}

fun createBST():BstNode{
    var root:BstNode
    var node:BstNode
    val ara= arrayOf(5,17,3,7,12,19,1,4)
    root= BstNode(10)
    for (item in ara){
        node=BstNode(item)
        root=node.bstInsert(root,node)
    }
    return root
}

fun bstSearch(root:BstNode?,item:Int):BstNode?{
    var node=root
    while (node!=null){
        if (node.data==item){
            return node
        }
        if (node.data<=item){
            node=node.right
        }else{
            node=node.left
        }
    }
    return null
}

fun main() {
    val root= createBST()
    root.preOrder(root)
    println()
    root.inOrder(root)
    println()
    root.postOrder(root)
    println()
    var node= bstSearch(root,7)
    if (node!=null){
        println("data found in binary search tree: ${node.data}")
    }else{
        println("Data not found")
    }
    node= bstSearch(root,8)
    if (node!=null){
        println("data found in binary search tree: ${node.data}")
    }else{
        println("Data not found")
    }
}








