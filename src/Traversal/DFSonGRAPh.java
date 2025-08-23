package Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DFSonGRAPh {
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=v; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(4);
        adj.get(4).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        boolean[] visited = new boolean[v+1];
        System.out.println("Printing Graph through DFS.");

        dfs(1, adj, visited);
    }
    public static void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[start] = true;
        System.out.print(start+ " ");
        for(int neighbour : adj.get(start)) {
           if(!visited[neighbour]){
               dfs(neighbour, adj, visited);
           }
        }
    }
}