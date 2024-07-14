package graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for (int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    // O(log n ) --> O (4 * alpha ) it is nearly constant time
    public int findParent(int node){
        if (node==parent.get(node)){
            return node;
        }
        int ultimateParent=findParent(parent.get(node));
        parent.set(node,ultimateParent);
        return parent.get(node);
    }
    // O(log n ) --> O (4 * alpha ) it is nearly constant time
    public void unionByRank(int u, int v){
        int ultimateParentOfU = findParent(u);
        int ultimateParentOfV = findParent(v);
        if (ultimateParentOfV == ultimateParentOfU){
            return;
        }
        if (rank.get(ultimateParentOfU)<rank.get(ultimateParentOfV)){
            parent.set(ultimateParentOfU,ultimateParentOfV);
        } else if (rank.get(ultimateParentOfV)<rank.get(ultimateParentOfU)) {
            parent.set(ultimateParentOfV,ultimateParentOfU);
        }else{
            parent.set(ultimateParentOfV,ultimateParentOfU);
            int rankU = rank.get(ultimateParentOfU);
            rank.set(ultimateParentOfU,rankU+1);
        }
    }
    // O(log n ) --> O (4 * alpha ) it is nearly constant time
    public void unionBySize(int u, int v){
        int ultimateParentOfU = findParent(u);
        int ultimateParentOfV = findParent(v);
        if (ultimateParentOfV == ultimateParentOfU){
            return;
        }
        if (size.get(ultimateParentOfU)<size.get(ultimateParentOfV)){
            parent.set(ultimateParentOfU,ultimateParentOfV);
            size.set(ultimateParentOfV,size.get(ultimateParentOfU)+size.get(ultimateParentOfV));
        }else{
            parent.set(ultimateParentOfV,ultimateParentOfU);
            size.set(ultimateParentOfU,size.get(ultimateParentOfU)+size.get(ultimateParentOfV));
        }
    }
}

class Main {
    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(7);
        disjointSet.unionBySize(1,2);
        disjointSet.unionBySize(2,3);
        disjointSet.unionBySize(4,5);
        disjointSet.unionBySize(6,7);
        disjointSet.unionBySize(5,6);
        if (disjointSet.findParent(3) == disjointSet.findParent(7)){
            System.out.println("Same ");
        }else{
            System.out.println("Not same");
        }
        disjointSet.unionBySize(3,7);
        if (disjointSet.findParent(3) == disjointSet.findParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not same");
        }
    }
}
