package graph

import java.util.*


fun main() {

    // Example usage
    val V = 5 // Number of vertices
    val S = 0 // Source node
    val adj = ArrayList<ArrayList<ArrayList<Int>>>()


    // Initialize adjacency list
    for (i in 0 until V) {
        adj.add(ArrayList())
    }


    // Add edges (example graph)
    //first one is node and second one is weight
    adj[0].add(ArrayList(mutableListOf(1, 2)))
    adj[0].add(ArrayList(mutableListOf(3, 1)))
    adj[1].add(ArrayList(mutableListOf(2, 3)))
    adj[1].add(ArrayList(mutableListOf(0, 2)))
    adj[2].add(ArrayList(mutableListOf(3, 1)))
    adj[2].add(ArrayList(mutableListOf(1, 3)))
    adj[3].add(ArrayList(mutableListOf(4, 6)))
    adj[3].add(ArrayList(mutableListOf(0, 1)))
    adj[3].add(ArrayList(mutableListOf(2, 1)))

    val distances = dijkstra(V, adj, S)

    println("Shortest distances from source $S to all nodes:")
    for (i in distances.indices) {
        println("Node " + i + ": " + distances[i])
    }
}

fun dijkstra(V: Int, adj: ArrayList<ArrayList<ArrayList<Int>>>, S: Int): IntArray {
    // Write your code here
    // weighted undirected (cyclic or acyclic) connected graph
    //time complexity O( E log(V) )
    val comparator = Comparator<Pair<Int, Int>> { p1, p2 ->
        p1.first - p2.first
    }
    val pq = PriorityQueue(comparator)
    val dis: Array<Int> = Array(V) { 1000000000 } //10^8 or 1e9
    pq.add(Pair(0, S)) //first -> weight, second -> node
    dis[S] = 0
    while (pq.isNotEmpty()) {
        val distance = pq.first().first
        val node = pq.first().second
        pq.poll()
        for (it in adj[node]) {
            val edgeWeight = it[1]
            val adjNode = it[0]
            if (distance+edgeWeight  < dis[adjNode]){
                dis[adjNode] = distance+edgeWeight
                pq.add(Pair(dis[adjNode],adjNode))
            }
        }
    }
    return dis.toIntArray()
}