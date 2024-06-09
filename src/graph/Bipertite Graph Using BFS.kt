package graph


//problem link: https://www.geeksforgeeks.org/problems/bipartite-graph/1


fun check(node:Int,color:Array<Int>,adj:ArrayList<ArrayList<Int>>):Boolean{
    val q=ArrayDeque<Int>()
    color[node]=0
    q.addLast(node)
    while (q.isNotEmpty()){
        val tmp=q.first()
        q.removeFirst()
        for (it in adj[tmp]){
            if (color[it]==-1){
                if (color[tmp]==0){
                    color[it]=1
                }else{
                    color[it]=0
                }
            }else if(color[it]==color[tmp]){
                return false
            }
        }
    }
    return true
}
fun isBipartite(V:Int,adj:ArrayList<ArrayList<Int>>):Boolean{
    val color= Array(V){-1}
    for (i in 0..<V){
        if (color[i]==-1){
            if (!check(i,color,adj)){
                return false
            }
        }
    }
    return true
}

fun main() {

    // V = 4, E = 4
    val adj = ArrayList<ArrayList<Int>>()
    for (i in 0..3) {
        adj.add(ArrayList())
    }
    adj[0].add(2)
    adj[2].add(0)
    adj[0].add(3)
    adj[3].add(0)
    adj[1].add(3)
    adj[1].add(0)
    adj[3].add(1)
    adj[2].add(3)
    adj[3].add(2)

    val ans: Boolean = isBipartite(4,adj)
    if (ans) println("Bipartite")
    else println("Not Bipartite")

    //complexity -> O(V+2E)
    //Space Complexity -> O(V)
}