package graph

import java.util.Stack
import kotlin.*
import kotlin.Pair

fun shortestPath(N: Int, M: Int, edges: Array<IntArray>): IntArray {
    //Code here
    val adj = mutableListOf<MutableList<Pair<Int, Int>>>()
    //for create n empty vertices
    for (i in 0..<N) {
        adj.add(mutableListOf())
    }
    for (i in 0..<M) {
        val u = edges[i][0]
        val v = edges[i][1]
        val wt = edges[i][2]
        adj[u].add(Pair(v, wt))
    }
    val vis = Array(N) { false }
    //perform topo sort
    //O(N+M)
    val stack = Stack<Int>()
    for (i in 0..<N) {
        if (!vis[i]) {
            topoSortUsingDFS(i, stack, adj, vis)
        }
    }
    //Further, we declare a vector ‘dist’ in which we update the value of the nodes’
    //distance from the source vertex after relaxation of a particular node.
    val dist = Array(N) { Int.MAX_VALUE }
    //src vertex is zero said to the problem statement.Topological sort first node is the source node.Because u come before v.
    // so first node has always indegre 0 and last node has always outdegre zero
    dist[0]=0
    //O(N+M)
    while (stack.isNotEmpty()){
        val node=stack.pop()
        for (it in adj[node]){
            if (dist[node]+it.second<dist[it.first]){
                dist[it.first]=dist[node]+it.second
            }
        }
    }
    for (i in 0..<N){
        if (dist[i]== Int.MAX_VALUE){
            dist[i]=-1
        }
    }
    return dist.toIntArray()
}

fun topoSortUsingDFS(node: Int, stack: Stack<Int>, adj: MutableList<MutableList<Pair<Int, Int>>>, vis: Array<Boolean>) {
    vis[node] = true
    for (it in adj[node]) {
        if (!vis[it.first]) {
            topoSortUsingDFS(it.first, stack, adj, vis)
        }
    }
    stack.add(node)
}

//time complexity O(N+M)