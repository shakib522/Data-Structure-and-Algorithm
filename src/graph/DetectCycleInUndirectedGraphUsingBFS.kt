package graph

fun detect(src:Int,adj:ArrayList<ArrayList<Int>>,vis:Array<Boolean>):Boolean{
    vis[src]=true
    val q=ArrayDeque<Pair<Int,Int>>()
    q.addFirst(Pair(src,-1)) //src,parent
    while (q.isNotEmpty()){
        val node=q.first().first
        val parent=q.first().second
        q.removeFirst()
        for (i in adj[node]){
            if (!vis[i]){
                vis[i]=true
                q.addLast(Pair(i,node))
            }else if (parent!=i){
                return true
            }
        }
    }
    return false
}

fun isCycle(V:Int,adj:ArrayList<ArrayList<Int>>):Boolean{
    val vis=Array(V){false}
    for (i in 0..< V){
        if (!vis[i]){
            if (detect(i,adj,vis)){
                return true
            }
        }
    }
    return false
}

//time complexity - O(N+2E) + O(N) {O(N) for component} -> O(N+2E)
//space complexity - O(N)