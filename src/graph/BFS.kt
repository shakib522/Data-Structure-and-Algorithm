package graph


class BFS{
    // 1 based graph
    fun bfsOfGraph(numberOfNodes:Int,adj:ArrayList<ArrayList<Int>>):ArrayList<Int>{
        val bfs=ArrayList<Int>()
        val vis=BooleanArray(numberOfNodes){false}
//        val qq:Queue<Int> = LinkedList()
        val q=ArrayDeque<Int>()
        q.add(1)
        vis[1]=true
        while (q.isNotEmpty()){
            val node=q.removeFirst()
            bfs.add(node)
            // Get all adjacent vertices of the dequeued element
            //if an adjacent has not been visited then visit the adjacent
            //and enqueue to the bfs queue
            for (i in adj[node]){
                if (!vis[i]){
                    vis[i]=true
                    q.add(i)
                }
            }
        }
        return bfs
    }

    fun bfsUsingAdjacencyMatrix(adj:Array<IntArray>,startNode:Int){
        //Time Complexity: O(N*N)
        //Auxiliary Space: O(N)
        val visited=Array(adj.size){false}
        val q=ArrayDeque<Int>()
        val ansBfs= mutableListOf<Int>()
        q.addFirst(startNode)
        visited[startNode]=true
        while (q.isNotEmpty()){
            val node=q.removeFirst()
            ansBfs.add(node)
            for(i in 0..< adj[node].size){
                if(adj[node][i]==1 && !visited[i]){
                    q.addLast(i)
                    visited[i]=true
                }
            }
        }
        println(ansBfs)
    }
}
//auxiliary space complexity - O(3n) == O(n)
//time complexity - O(n) + O(2E)  //the queue is run for all element.So it's complexity is O(N).
// And the internal for loop run on all degrees.So it's complexity is O(2E)

fun main() {
    val bfs=BFS()
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
    println("--BFS--")
    println(bfs.bfsOfGraph(9,adj))

//  0 based graph
    val isConnected= Array(5){IntArray(5)}
    isConnected[0]= intArrayOf(0,1,0,0,1)
    isConnected[1]= intArrayOf(1,0,1,1,0)
    isConnected[2]= intArrayOf(0,1,0,0,0)
    isConnected[3]= intArrayOf(0,1,0,0,0)
    isConnected[4]= intArrayOf(1,1,0,0,0)
    println("--BFS using adjacency matrix ---")
    bfs.bfsUsingAdjacencyMatrix(isConnected,0)
}