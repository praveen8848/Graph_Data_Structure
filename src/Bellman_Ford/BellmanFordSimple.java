package Bellman_Ford;

import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class BellmanFordSimple {
    public static void bellmanFord(int V, int E, int src, Edge[] edges) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 1: Relax edges V-1 times
        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.src] != Integer.MAX_VALUE &&
                        dist[e.src] + e.weight < dist[e.dest]) {

                    dist[e.dest] = dist[e.src] + e.weight;
                }
            }
        }

        // Step 2: Check for negative cycles
        for (Edge e : edges) {
            if (dist[e.src] != Integer.MAX_VALUE &&
                    dist[e.src] + e.weight < dist[e.dest]) {

                System.out.println("Negative cycle detected!");
                return;
            }
        }

        // Print result
        System.out.println("Distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 3; // nodes: 0=A, 1=B, 2=C
        int E = 3;

        Edge[] edges = new Edge[E];
        edges[0] = new Edge(0, 1, 4);   // A→B
        edges[1] = new Edge(0, 2, 5);   // A→C
        edges[2] = new Edge(1, 2, -2);  // B→C

        bellmanFord(V, E, 0, edges);
    }
}
