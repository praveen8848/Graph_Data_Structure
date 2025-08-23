package Traversal;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_2 {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        System.out.println("Traversal of Graph: ");
        g.B_F_S_Traversal(0);
    }
}
class Graph{
    private int vertices;
    private LinkedList<Integer>[] lst;
    Graph(int v){
        vertices = v;
        lst = new LinkedList[vertices];
        for (int i = 0; i < v; i++) {
            lst[i] = new LinkedList<>();
        }
    }
    public void addEdge(int u, int v){
        lst[u].add(v);
        lst[v].add(u);
    }
    void B_F_S_Traversal(int s){
        int[] check = new int[vertices];
        check[s] = 1;
        Queue<Integer> qt = new ArrayDeque<>();
        qt.offer(s);
        while (!qt.isEmpty()){
            int node = qt.poll();
            System.out.print(node + " ");
            for( int n : lst[node]){
                if(check[n] == 0){
                    qt.offer(n);
                    check[n]= 1;
                }
            }
        }
    }
}
