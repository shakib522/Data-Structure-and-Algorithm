package graph

import java.util.LinkedList
import java.util.Queue

fun shortestPath(
    edges: Array<IntArray>, n: Int, m: Int, src: Int
): IntArray {
    // Code here
    val adj= mutableListOf<MutableList<Int>>()
    for (i in 0..<n){
        adj.add(mutableListOf())
    }
    for (i in 0..<m){
        adj[edges[i][0]].add(edges[i][1])
        adj[edges[i][1]].add(edges[i][0])
    }
    //run a plain bfs
    val q:Queue<Int> =LinkedList()
    q.add(src)
    val dist=Array(n){Int.MAX_VALUE}
    dist[src]=0
    while (q.isNotEmpty()){
        val node=q.poll()
        for (it in adj[node]){
            if(dist[it]>dist[node]+1){
                dist[it]=dist[node]+1
                q.add(it)
            }
        }
    }
    for (i in dist.indices){
        if (dist[i]==Int.MAX_VALUE){
            dist[i]=-1
        }
    }
    return dist.toIntArray()
}