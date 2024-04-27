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
}