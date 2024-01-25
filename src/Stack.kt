
class Stak (val stackSize:Int, var top:Int){
    val data=IntArray(stackSize)
}

fun push(stack:Stak,item:Int){
    if(stack.top<stack.stackSize){
        stack.data[stack.top]=item
        stack.top++
    }else{
        println("Stack is full")
    }
}
fun pop(stack:Stak):Int{
    if(stack.top==0){
        println("Stack is empty")
        return -1
    }else{
        stack.top--
        return stack.data[stack.top]
    }
}

fun topElement(stack:Stak):Int{
    return stack.data[stack.top-1]
}

fun isEmpty(stack:Stak):Boolean{
    return stack.top==0
}

fun siZe(stack:Stak):Int{
    return stack.top
}
fun main() {
    val stack=Stak(20,0)
    push(stack,3)
    push(stack,13)
    push(stack,34)
    push(stack,311)
    push(stack,68390)
    push(stack,4)
    println(pop(stack))
    println(pop(stack))
    println("Top element: "+topElement(stack))
    println(pop(stack))
    println(pop(stack))
    println(pop(stack))
    println(pop(stack))
    push(stack,400)
    push(stack,10)
    push(stack,12)
    println("size: "+siZe(stack))
    println(pop(stack))
    println(pop(stack))
    println(pop(stack))
    println("is empty: "+isEmpty(stack))

}