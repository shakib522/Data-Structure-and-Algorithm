package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeInGraphUsingTerjanAlgorithms {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
                {0, 1}, {1, 2},
                {2, 0}, {1, 3}
        };
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            connections.get(i).add(edges[i][0]);
            connections.get(i).add(edges[i][1]);
        }

        BridgeInGraphUsingTerjanAlgorithms obj = new BridgeInGraphUsingTerjanAlgorithms();
        List<List<Integer>> bridges = obj.criticalConnections(n, connections);

        int size = bridges.size();
        for (int i = 0; i < size; i++) {
            int u = bridges.get(i).get(0);
            int v = bridges.get(i).get(1);
            System.out.print("[" + u + ", " + v + "] ");
        }
        System.out.println(" ");
    }
    private int timer = 1;
    private void dfs(int node,int parent,boolean[] vis,ArrayList<ArrayList<Integer>> adj,int[] timeOfInsert,int[] low,List<List<Integer>> bridges){
        vis[node]=true;
        timeOfInsert[node]=low[node]=timer;
        timer++;
        for (Integer adjacent: adj.get(node)){
            if (adjacent==parent) continue; //because it is undirected graph.the parent node are also in the child adjacent list.
            if (!vis[adjacent]){
                dfs(adjacent,node,vis,adj,timeOfInsert,low,bridges);
                low[node]=Math.min(low[node],low[adjacent]);
                if (low[adjacent]>timeOfInsert[node]){
                    //it is a bridge
                    bridges.add(Arrays.asList(adjacent,node));
                }
            }else{
                low[node]=Math.min(low[node],low[adjacent]);
            }
        }
    }
    //tarjan algorithm
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //0 based graph.n=number of node from 0 to n-1
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int[] timeOfInsert = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,vis,adj,timeOfInsert,low,bridges);
        return bridges;
    }
}
