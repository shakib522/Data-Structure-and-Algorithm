package graph

import java.util.*
import kotlin.collections.ArrayList

fun main(){
}
fun detectCycle(
    stack: Stack<Int>,adj:ArrayList<ArrayList<Int>>,v:Int
) :Boolean {
    val map:MutableMap<Int,Int> = HashMap ()
    var indx=0
    while (stack.isNotEmpty()){
        map[stack.pop()]=indx++
    }
    for (i in 0..<v){
        for (it in adj[i]){
            if(map[i]!!>map[it]!!){
                return true
            }
        }
    }
    return false
}
