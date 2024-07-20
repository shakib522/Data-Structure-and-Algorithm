package graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithmSCC {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {1, 0}, {0, 2},
                {2, 1}, {0, 3},
                {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int ans = kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: " + ans);
    }

    public static int kosaraju(int v,ArrayList<ArrayList<Integer>>adj){
        int[] vis = new int[v];
        Stack<Integer> st = new Stack<>();
        for (int i =0 ;i<v;i++){
            if (vis[i]==0){
                dfsUsingStack(i,vis,adj,st);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i =0 ;i<v;i++){
            adjT.add(new ArrayList<>());
        }
        for (int i =0 ;i<v;i++){
            vis[i]=0;
            for (int j=0;j<adj.get(i).size();j++){
                adjT.get(adj.get(i).get(j)).add(i);
            }
        }
        int scc=0;
        while (!st.isEmpty()){
            int node=st.peek();
            st.pop();
            if (vis[node]==0){
                scc++;
                dfs(node,vis,adjT);
            }
        }
        return scc;
    }

    private static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (int i = 0; i < adjT.get(node).size(); i++) {
            if (vis[adjT.get(node).get(i)]==0){
                dfs(adjT.get(node).get(i), vis, adjT);
            }
        }
    }

    private static void dfsUsingStack(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            if (vis[adj.get(node).get(i)]==0){
                dfs(adj.get(node).get(i), vis, adj);
            }
        }
        st.push(node);
    }
}
