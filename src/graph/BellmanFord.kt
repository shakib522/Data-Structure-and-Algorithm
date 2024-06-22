package graph


fun bellman_ford(V: Int, edges: ArrayList<ArrayList<Int>>, S: Int): IntArray {
    // Write your code here
    val distance=IntArray(V){100000000}
    distance[S]=0
    //time complexity -> O (V * E )
    for (i in 0..<V){
        for (edge in edges){
            val u=edge[0]
            val v=edge[1]
            val wt=edge[2]
            if (distance[u]!=100000000 && distance[u]+wt<distance[v]){
                distance[v]=distance[u]+wt
            }
        }
    }
    //check for negative cycle

    for (edge in edges){
        val u=edge[0]
        val v=edge[1]
        val wt=edge[2]
        if (distance[u]!=100000000 && distance[u]+wt<distance[v]){
            return intArrayOf(-1)
        }
    }
    return distance
}