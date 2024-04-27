package graph

class DFS {

    //1 based graph

    fun dfsOfGraph(numberOfNode:Int,adj:ArrayList<ArrayList<Int>>):ArrayList<Int>{
        val visited=Array(numberOfNode){false}
        val ans=ArrayList<Int>()
        dfs(1,adj,visited,ans)
        return ans
    }

    private fun dfs(node:Int, adj:ArrayList<ArrayList<Int>>, visited:Array<Boolean>, ans:ArrayList<Int>){
        visited[node]=true
        ans.add(node)
        //traverse all its neighbour
        for (i in adj[node]){
            if (!visited[i]){
                dfs(i,adj,visited,ans)
            }
        }
    }
}

fun main() {
    val adj=ArrayList<ArrayList<Int>>(9)
    adj.add(arrayListOf())
    adj.add(arrayListOf(2,3))
    adj.add(arrayListOf(1,5,6))
    adj.add(arrayListOf(1,4,7))
    adj.add(arrayListOf(3,8))
    adj.add(arrayListOf(2))
    adj.add(arrayListOf(2))
    adj.add(arrayListOf(3,8))
    adj.add(arrayListOf(4,7))
    val dfs=DFS()
    println("--DFS--")
    println(dfs.dfsOfGraph(9,adj))
}