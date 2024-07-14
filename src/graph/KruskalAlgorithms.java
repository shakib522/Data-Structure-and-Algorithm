package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgorithms {
    public static void main(String[] args) {

    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        List<Pair<Integer,Pair<Integer,Integer>>> edges = new ArrayList<>();
        // O (N+E)
        for (int i =0 ; i<V ; i++){
            for (int[] it : adj.get(i)){
                int adjNode = it[0];
                int weight = it[1];
                int node = i;
                edges.add(new Pair<>(weight,new Pair<>(node, adjNode)));
            }
        }
        Comparator<Pair<Integer,Pair<Integer,Integer>>> comparator = new Comparator<>() {
            @Override
            public int compare(Pair<Integer, Pair<Integer, Integer>> o1, Pair<Integer, Pair<Integer, Integer>> o2) {
                return o1.first - o2.first;
            }
        };
        DisjointSet disjointSet=new DisjointSet(V);
        edges.sort(comparator); // O (M Log M )
        int mstWeight = 0;
        //O (M * 4 * alpha * 2 )
        for (int i =0 ; i< edges.size() ; i++ ){
            int weight = edges.get(i).first;
            int u = edges.get(i).second.first;
            int v = edges.get(i).second.second;
            if (disjointSet.findParent(u)!=disjointSet.findParent(v)){
                mstWeight+=weight;
                disjointSet.unionBySize(u,v);
            }
        }
        return mstWeight;
    }
}
