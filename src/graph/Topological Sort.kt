package graph

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val adj= arrayListOf<ArrayList<Int>>()
    adj.add(arrayListOf())
    adj.add(arrayListOf())
    adj.add(arrayListOf(3))
    adj.add(arrayListOf(1))
    adj.add(arrayListOf(0,1))
    adj.add(arrayListOf(0,2))
    println(topoSort(6,adj))
}

fun topoSort(V:Int,adj:ArrayList<ArrayList<Int>>):List<Int> {
    val st=Stack<Int>()
    val vis=Array(V){false}
    for(i in 0..<V){
        if (!vis[i]){
            topoDFS(i,st,vis,adj)
        }
    }
//    println(detectCycle(st,adj,V)) //stack popped in the function detect cycle.
    // That's why it is not printing anything
    val ans= mutableListOf<Int>()
    while (st.isNotEmpty()){
        ans.add(st.pop())
    }
    return ans
}

fun topoDFS(node:Int, st: Stack<Int>, vis:Array<Boolean>, adj:ArrayList<ArrayList<Int>>){
    vis[node]=true
    for (it in adj[node]){
        if (!vis[it]){
            topoDFS(it,st,vis,adj)
        }
    }
    st.push(node)
}

//time complexity: O(V+E)
// only available for DAG -> direct acyclic graph
//we can check cycle in directed graph using topological sorting