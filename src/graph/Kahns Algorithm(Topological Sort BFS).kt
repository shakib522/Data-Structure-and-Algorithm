package graph

import java.util.LinkedList
import java.util.Queue


fun main(){
    val adj= arrayListOf<ArrayList<Int>>()
    adj.add(arrayListOf())
    adj.add(arrayListOf())
    adj.add(arrayListOf(3))
    adj.add(arrayListOf(1))
    adj.add(arrayListOf(0,1))
    adj.add(arrayListOf(0,2))
    println(topoSortUsingKahnAlgo(6,adj))
}

fun topoSortUsingKahnAlgo(
    v: Int, adj: ArrayList<ArrayList<Int>>
): List<Int> {
    val indegre = Array(v) { 0 }
    for (i in 0..<v) {
        for (it in adj[i]) {
            indegre[it]++
        }
    }
    val q: Queue<Int> = LinkedList()
    for (i in 0..<v) {
        if (indegre[i] == 0) {
            q.add(i)
        }
    }
    val topo = mutableListOf<Int>()
    while (q.isNotEmpty()) {
        val node = q.poll()
        topo.add(node)
        for (it in adj[node]) {
            indegre[it]--
            if (indegre[it] == 0) {
                q.add(it)
            }
        }
    }
    return topo
}

//time complexity O(V+E)