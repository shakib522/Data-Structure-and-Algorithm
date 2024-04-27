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

//space complexity: O(n) + O(n) + O(n) -> O(n) // First one is for dfs ans.Second one is for visited.
// Third one is for recursion call.stack size in worst case is O(n)

//time complexity : O(n) + O(2E)  | O(n) for dfs function and O(2E) for visited every neighbour in for loop.
// So we can say total degree of graph is executed in the for loop what is equivalent to 2*E (E for edges)