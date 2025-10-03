package D_i_j_k_s_t_r_a_s;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraExample {
    public static void main(String[] args) {
        List<List<Pair>> adj = new ArrayList<>();
        int n = 4;

        // Initialising Adjacency  List
        for(int i = 0;i<n; i++){
            adj.add(new ArrayList<>());
        }
        // add edges (undirected graph)
        adj.get(0).add(new Pair(1, 2)); // A -> B
        adj.get(0).add(new Pair(3, 1)); // A -> D
        adj.get(1).add(new Pair(0, 2)); // B -> A
        adj.get(1).add(new Pair(2, 3)); // B -> C
        adj.get(2).add(new Pair(1, 3)); // C -> B
        adj.get(2).add(new Pair(3, 5)); // C -> D
        adj.get(3).add(new Pair(0, 1)); // D -> A
        adj.get(3).add(new Pair(2, 5)); // D -> C

        Dijkstra_Algo(n, adj,2);
    }
    public static void Dijkstra_Algo(int n, List<List<Pair>> adj, int source){
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b) -> a.weight - b.weight
        );
        pq.add(new Pair(source,0));

        while (!pq.isEmpty()){
            Pair current = pq.poll();
            int u = current.node;
            int d = current.weight;

            if(d>dist[u]){
                continue;
            }

            for(Pair neighbor : adj.get(u)){
                int v = neighbor.node;
                int weight = neighbor.weight;

                if(dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v])); // add updated distance to pq
                }
            }
        }
        // 5. Print shortest distances
        System.out.println("Shortest distances from node " + source + ":");
        for(int i = 0; i < n; i++) {
            System.out.println("Node " + i + " -> " + dist[i]);
        }
    }
}

class Pair{
    int node;
    int weight;
    Pair(int n, int w){
        node = n;
        weight = w;
    }
}
