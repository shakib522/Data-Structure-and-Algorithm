package graph

import java.util.Scanner


fun main() {
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()
    val m = scan.nextInt()
    //store undirected graph using adjacency matrix
    val adj = Array(n) { Array(m) { 0 } }
    for (i in 0..<m) {
        val u = scan.nextInt()
        val v = scan.nextInt()
        adj[u][v] = 1
        adj[v][u] = 1
    }
    //for unweighted undirected graph
    val undirectedGraph = Array<MutableList<Int>>(n) { mutableListOf() }

    for (i in 0..<m) {
        val u = scan.nextInt()
        val v = scan.nextInt()
        undirectedGraph[u].add(v)
        undirectedGraph[v].add(u)//comment this line for directed line
    }

    //for directed unweighted graph

    val directedGraph = Array<MutableList<Int>>(n) { mutableListOf() }
    for (i in 0..<m) {
        val u = scan.nextInt()
        val v = scan.nextInt()
        directedGraph[u].add(v)
//      directedGraph[v].add(u)
    }
}