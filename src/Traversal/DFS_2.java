package Traversal;

import java.util.LinkedList;

public class DFS_2 {
    public static void main(String[] args) {
        Graph2 g = new Graph2(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        boolean[] visited = new boolean[6];
        System.out.println("Traversal ");
        g.D_F_S_Traversal(0,visited);
    }
}
class Graph2{
    private int V;
    private LinkedList<Integer>[] adj;

    Graph2(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0;i <v; i++){
            adj[i] = new LinkedList<>();
        }
    }
    void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }
    void D_F_S_Traversal(int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s+ " ");
        for(int n : adj[s]){
            if(!visited[n]){
                visited[n] = true;
                D_F_S_Traversal(n, visited);
            }
        }
    }
}
