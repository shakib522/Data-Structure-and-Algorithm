package graph

fun main() {
    val adj = ArrayList<ArrayList<Int>>()
    adj.add(arrayListOf())
    adj.add(arrayListOf(1))
    adj.add(arrayListOf(2))
    adj.add(arrayListOf(3,6))
    adj.add(arrayListOf(4))
    adj.add(arrayListOf(5))
    adj.add( arrayListOf())
    adj.add(arrayListOf(4))
    adj.add( arrayListOf(8,1))
    adj.add(arrayListOf(9))
    adj.add(arrayListOf())
    println(isCycleUsingDfs(10,adj))
}

fun isCycleUsingDfs(V: Int, adj: ArrayList<ArrayList<Int>>) :Boolean{
    val vis=Array(V){false}
    val pathVisited=Array(V){false}
    for(i in 0..<V){
        if(dfsCheck(i,vis,pathVisited,adj)){
            return true
        }
    }
    return false
}

fun dfsCheck(
    node: Int, vis: Array<Boolean>, pathVisited: Array<Boolean>,
    adj:ArrayList<ArrayList<Int>>
):Boolean {
    vis[node]=true
    pathVisited[node]=true
    for (i in adj[node]){
        if (!vis[i]){
            if(dfsCheck(i,vis,pathVisited,adj)){
                return true
            }
        }else if(pathVisited[i]){
            return true
        }
    }
    pathVisited[node]=false
    return false
}

//time complexity -> O (N+E)
//space -> O(n)