package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair<T,U>{
    T first;
    U second;
    Pair(T first, U second){
        this.first = first;
        this.second = second;
    }
    public T getFirst(){
        return first;
    }
    public U getSecond(){
        return second;
    }

    public void setFirst(T first){
        this.first = first;
    }
    public void setSecond(U second){
        this.second = second;
    }

}

public class PrimsAlgorithms {
    public static void main(String[] args) {

    }

    //arraylist structure-> 0 -{(1,3),(2,4)} -> adjacent list where the first element of pair is node and the second value is the weight
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        Comparator<Pair<Integer,Integer>> comparator = new Comparator<>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.first-o2.first;
            }
        };
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(comparator);
        int [] visited = new int[V];
        //pair -> first = distance -> second = node
        pq.add(new Pair<>(0,0));
        int sum=0;
        while (!pq.isEmpty()){
            int wt = pq.peek().first;
            int node = pq.peek().second;
            pq.poll();
            if (visited[node]==1){
                continue;
            }
            visited[node]=1;
            sum+=wt;
            for (int i=0; i<adj.get(node).size();i++){
                int edgeWeight = adj.get(node).get(i).get(1); //weight
                int adjNode = adj.get(node).get(i).get(0); //node
                if (visited[adjNode] == 0){
                    pq.add(new Pair<>(edgeWeight,adjNode));
                }
            }
        }
        return sum;
    }
}