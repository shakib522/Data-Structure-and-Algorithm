package graph;


import java.util.ArrayList;
import java.util.Arrays;
//undirected graph
class DetectCycleUsingDFS{
    public static void main(String[] args) {
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean [] vis = new boolean[V];
        Arrays.fill(vis, false);
        for (int i=0;i<V;i++){
            if (!vis[i]){
                if (dfs(i,-1,vis,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean dfs(int node,int parent,boolean [] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for (int i=0;i<adj.get(node).size();i++){
            if (!vis[adj.get(node).get(i)]){
                if(dfs(adj.get(node).get(i),node,vis,adj)){
                    return true;
                }
            }else if(parent!=adj.get(node).get(i)){
                return true;
            }
        }
        return false;
    }
}

// space complexity -> O(N) //recursion call stack (N) + visited array (N)
// Time complexity -> O(N+2E) + O(N)