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
    fun dfsInAdjacencyMatrix(ans: ArrayList<Int>, vis: Array<Boolean>, node: Int, isConnected: Array<IntArray>):ArrayList<Int> {
        vis[node] = true
        ans.add(node+1)
        for (j in isConnected[node].indices) {
            if (isConnected[node][j] == 1 && !vis[j]) {
                dfsInAdjacencyMatrix(ans, vis, j, isConnected)
            }
        }
        return ans
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


    val ans= arrayListOf<Int>()
    val vis = Array(3) { false }
    val isConnected= Array(3){IntArray(3)}
    isConnected[0]= intArrayOf(1,1,0)
    isConnected[1]= intArrayOf(1,1,1)
    isConnected[2]= intArrayOf(0,1,1)
    println("--DFS using adjacency matrix ---")
    println(dfs.dfsInAdjacencyMatrix(ans,vis,0,isConnected))



}

//space complexity: O(n) + O(n) + O(n) -> O(n) // First one is for dfs ans.Second one is for visited.
// Third one is for recursion call.stack size in worst case is O(n)

//time complexity : O(n) + O(2E)  | O(n) for dfs function and O(2E) for visited every neighbour in for loop.
// So we can say total degree of graph is executed in the for loop what is equivalent to 2*E (E for edges)