package graph;

import java.util.ArrayList;

public class ArticulationPoint {
    private int timer=1;
    public static void main(String[] args) {
        int n=5;
        int[][] edges = {
                {0,1}, {1,4},
                {2,4},{2,3},{3,4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ArticulationPoint solution = new ArticulationPoint();
        ArrayList<Integer> nodes = solution.articulationPoint(n,adj);
        for (int i=0;i<nodes.size();i++){
            int node = nodes.get(i);
            System.out.print(node+ " ");
        }
        System.out.println(" ");

    }
    void dfs(int node,int parent,int[] vis,int[] timeOfInsert, int[] low, int[] mark,ArrayList<ArrayList<Integer>>adj){
        vis[node]=1;
        timeOfInsert[node]=low[node]=timer;
        timer++;
        int child=0;
        for (Integer adjacent: adj.get(node)){
            if (adjacent==parent) continue;
            if (vis[adjacent]==0){
                dfs(adjacent,node,vis,timeOfInsert,low,mark,adj);
                if (low[adjacent]>= timeOfInsert[node] && parent!=-1){
                    mark[node]=1;
                }
                child++;
            }else{
                low[node] = Math.min(low[node],timeOfInsert[adjacent]);
            }
        }
        if (child>1&&parent==-1){
            mark[node]=1;
        }
    }
    public ArrayList<Integer> articulationPoint(int n,ArrayList<ArrayList<Integer>>adj){
        int[] vis = new int[n];
        int[] timeOfInsert = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];
        for (int i=0;i<n;i++){
            if (vis[i]==0){
                dfs(i,-1,vis,timeOfInsert,low,mark,adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0;i<n;i++){
            if (mark[i]==1){
                ans.add(i);
            }
        }
        if (ans.isEmpty()){
            ans.add(-1);
        }
        return ans;
    }
}
//space -> O(3N)
//time -> O(V+2E)